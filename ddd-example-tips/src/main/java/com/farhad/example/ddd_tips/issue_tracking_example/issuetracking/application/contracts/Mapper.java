package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts;

public interface Mapper<T, R> {

	R map(T t);
	
}
