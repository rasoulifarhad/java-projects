package com.farhad.example.ddd_tips.specifications;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NotSpecification<T> extends AbstractSpecification<T> {

	private Specification<T> spec;

	@Override
	public boolean isSatisfiedBy(T t) {
		return !spec.isSatisfiedBy(t);
	}
	
}
