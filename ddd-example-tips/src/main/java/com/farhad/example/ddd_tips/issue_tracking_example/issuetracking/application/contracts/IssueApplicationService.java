package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts.issue.IssueAssignDTO;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts.issue.IssueCreationDTO;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts.issue.IssueDTO;

public interface IssueApplicationService {
	public void createComment(CreateCommentDTO input);
	public void assign(IssueAssignDTO input);
	IssueDTO create(IssueCreationDTO input);
	IssueDTO update(String issueId, IssueCreationDTO input);
}
