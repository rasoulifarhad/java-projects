package com.farhad.example.ddd_tips.specifications;

public abstract class AbstractSpecification<T> implements Specification<T>{
	public abstract boolean isSatisfiedBy(T t);

	@Override
	public Specification<T> and(Specification<T> specification) {
		return new AndSpecification<>(this, specification);
	}

	@Override
	public Specification<T> not(Specification<T> specification) {
		return new NotSpecification<>(specification);
	}

	@Override
	public Specification<T> or(Specification<T> specification) {
		return new OrSpecification<>(this, specification );
	}
	

}
