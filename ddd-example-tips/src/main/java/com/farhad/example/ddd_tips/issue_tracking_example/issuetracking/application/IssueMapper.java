package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts.IssueDTO;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts.Mapper;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.Issue;

public class IssueMapper implements Mapper<Issue, IssueDTO>{

	@Override
	public IssueDTO map(Issue issue) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'map'");
	}
	
}
