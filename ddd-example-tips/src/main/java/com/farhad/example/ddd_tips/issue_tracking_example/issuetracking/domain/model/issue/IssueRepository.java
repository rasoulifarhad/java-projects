package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.issue;

import java.util.List;
import java.util.Optional;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.issue.Issue.IssueId;
import com.farhad.example.ddd_tips.specifications.Specification;

public interface IssueRepository {

	Optional<Issue> findById(IssueId id);

	void save(Issue issue);
	List<Issue> getIssues(Specification<Issue> spec);
	Integer count(Specification<Issue> spec);

	boolean any(Specification<Issue> specification ); 
	
}
