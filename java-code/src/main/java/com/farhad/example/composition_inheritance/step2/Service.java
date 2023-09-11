package com.farhad.example.composition_inheritance.step2;

public interface Service<T> {
	
	String generateId();
	T save(T t);
}
