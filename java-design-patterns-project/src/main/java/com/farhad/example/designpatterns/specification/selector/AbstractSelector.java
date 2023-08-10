package com.farhad.example.designpatterns.specification.selector;

import java.util.function.Predicate;

public interface AbstractSelector<T> extends Predicate<T> {
	
	public  boolean test(T t); 
}
