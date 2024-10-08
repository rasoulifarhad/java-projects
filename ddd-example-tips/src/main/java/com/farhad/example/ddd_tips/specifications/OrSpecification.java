package com.farhad.example.ddd_tips.specifications;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrSpecification<T>  extends AbstractSpecification<T>{

	private Specification<T> spec1;
	private Specification<T> spec2;

	@Override
	public boolean isSatisfiedBy(T t) {
		return spec1.isSatisfiedBy(t) || spec2.isSatisfiedBy(t);
	}
	
}
