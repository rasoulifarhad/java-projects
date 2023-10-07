package com.farhad.example.ddd_tips.specifications;

@FunctionalInterface
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