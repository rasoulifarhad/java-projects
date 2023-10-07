package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model;

public class IssueStateException extends RuntimeException {
	
	public IssueStateException(String message) {
		super(message);
	}
}
