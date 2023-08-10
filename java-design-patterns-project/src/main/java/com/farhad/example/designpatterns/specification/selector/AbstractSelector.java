package com.farhad.example.designpatterns.specification.selector;

import java.util.function.Predicate;

public abstract class AbstractSelector<T> implements Predicate<T> {

	public AbstractSelector<T> and(AbstractSelector<T> other) {
		return new AndSelector<T>(this, other); 
	}

	public AbstractSelector<T> or(AbstractSelector<T> other) {
		return new OrSelector<T>(this, other);
	}

	public AbstractSelector<T> not() {
		return new NotSelector<T>(this); 
	}
}
