package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.issue;

import java.util.Objects;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.MilestoneId;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.Specification;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

// returns true only if the Issue is in a Milestone
@RequiredArgsConstructor
public class MilestoneSpecification implements Specification<Issue> {

	@NonNull
	private final MilestoneId milestoneId;

	@Override
	public boolean isSatisfiedBy(Issue issue) {
		Objects.requireNonNull(issue);
		return milestoneId.equals(issue.getMilestoneId());
	}

	@Override
	public Specification<Issue> and(Specification<Issue> specification) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'and'");
	}

	@Override
	public Specification<Issue> or(Specification<Issue> specification) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'or'");
	}

	@Override
	public Specification<Issue> not(Specification<Issue> specification) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'not'");
	}
	
}
