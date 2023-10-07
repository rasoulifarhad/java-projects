package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared;

public interface Specification<T> {
	boolean isSatisfiedBy(T t);

	default Specification<T> and(Specification<T> other){
		return t -> this.isSatisfiedBy(t) && other.isSatisfiedBy(t); 
	}
	default Specification<T> or(Specification<T> other) {
		return t -> this.isSatisfiedBy(t) || other.isSatisfiedBy(t); 
	}
	default Specification<T> not(Specification<T> other) {
		return t -> !other.isSatisfiedBy(t); 
	}
	
	default Specification<T> not() {
		return t -> !this.isSatisfiedBy(t); 
	}
}