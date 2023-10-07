package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.BusinessException;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.DomainService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IssueManager implements DomainService {

	private final IssueRepository issueRepository;

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
