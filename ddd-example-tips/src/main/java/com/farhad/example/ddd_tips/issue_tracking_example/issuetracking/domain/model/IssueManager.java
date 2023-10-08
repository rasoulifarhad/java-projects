package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.BusinessException;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.DomainService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IssueManager implements DomainService {


	private final IssueRepository issueRepository;

	public Issue create(GitRepository.Id gitRepositoryId, String title, String text) {
		if (issueRepository.any( i -> i.getTitle().equals(title))) {
			throw new BusinessException("IssueTracking.issieWithSameTitleExist");
		}
		return new Issue(
			Issue.IssueId.newId(), 
			title, 
			text, 
			gitRepositoryId);
	}

	public void assignTo(Issue issue, User user) {
		int openIssueCount =  issueRepository.count(i -> 
					user.getId().equals(i.getAssignedUserId()) && 
					!i.isClosed());
		if(openIssueCount >= 3) {
			throw new BusinessException("IssueTracking:ConcurrentOpenIssueLimit");
		}
		issue.setAssignedUserId(user.getId());
	}
	
}
