package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model;

import java.util.List;
import java.util.Optional;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.Issue.IssueId;
import com.farhad.example.ddd_tips.specifications.Specification;

public interface IssueRepository {

	Optional<Issue> findById(IssueId id);

	void save(Issue issue);
	List<Issue> getIssues(Specification<Issue> spec);
	
}
