package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.Issue.IssueId;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.Label.LableId;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.ValueObject;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class IssueLable implements ValueObject{

	private IssueId issueId;
	private LableId lableId;
	
}
