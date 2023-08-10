package com.farhad.example.designpatterns.specification.selector;

public class NotSelector<T> extends AbstractSelector<T> {

	private final AbstractSelector<T> selector;
	public NotSelector(AbstractSelector<T> selector) {
		this.selector = selector;
	}

	@Override
	public boolean test(T t) {
		return !selector.test(t);
	}
	
}
