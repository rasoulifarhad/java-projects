package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared;

public interface Specification<T> {
	boolean isSatisfiedBy(T t);

	Specification<T> and(Specification<T> specification);
	Specification<T> or(Specification<T> specification);
	Specification<T> not(Specification<T> specification);
}