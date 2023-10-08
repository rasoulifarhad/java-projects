package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.issue;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.BusinessException;

public class IssueStateException extends BusinessException {
	
	public IssueStateException(String code) {
		super(code);
	}
}
