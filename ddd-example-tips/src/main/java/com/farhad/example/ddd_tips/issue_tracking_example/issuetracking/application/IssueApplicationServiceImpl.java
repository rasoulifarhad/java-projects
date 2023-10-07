package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application;

import static com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.CurrentUser.USER_1;
import static com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.Issue.IssueId.from;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts.CreateCommentDTO;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts.IssueApplicationService;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.IssueRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IssueApplicationServiceImpl implements IssueApplicationService {

	private final IssueRepository issueRerpository;


	@Override
	public void CreateComment(CreateCommentDTO input) {
		issueRerpository.findById(from(input.getIssueId()))
				.ifPresent(issue -> {
					issue.addComment(USER_1.getUserId(), input.getText());
					issueRerpository.save(issue);
				});
	}
	
}
