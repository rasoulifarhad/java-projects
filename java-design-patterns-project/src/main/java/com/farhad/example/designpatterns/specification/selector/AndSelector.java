package com.farhad.example.designpatterns.specification.selector;

import java.util.Arrays;
import java.util.List;

public class AndSelector<T> extends AbstractSelector<T> {

	private final List<AbstractSelector<T>> selectors;

	@SafeVarargs
	public AndSelector(AbstractSelector<T>... selectors) {
		this.selectors = Arrays.asList(selectors);
	}

	@Override
	public boolean test(T t) {
		return selectors.stream().allMatch((selector) -> (selector.test(t)));
	}


}
