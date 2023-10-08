package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.issue;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.Specification;

public class InactiveIssueSpecification implements Specification<Issue> {

	@Override
	public boolean isSatisfiedBy(Issue issue) {
		Instant daysAgo30 = Instant.now()
								.truncatedTo(ChronoUnit.DAYS)
								.minus(30, ChronoUnit.DAYS);
		return 
			!issue.isClosed() && 
			issue.getAssignedUserId() == null && 

			issue.getCreationTime().isBefore(daysAgo30) &&
			(issue.getLastCommentTime() == null || issue.getLastCommentTime().isBefore(daysAgo30));
	}
	
}
