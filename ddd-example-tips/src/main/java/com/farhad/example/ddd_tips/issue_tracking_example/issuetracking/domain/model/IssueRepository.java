package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model;

import java.util.Optional;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.Issue.IssueId;

public interface IssueRepository {

	Optional<Issue> findById(IssueId id);

	void save(Issue issue);
	
}
