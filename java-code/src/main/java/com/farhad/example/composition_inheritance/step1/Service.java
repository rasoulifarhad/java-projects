package com.farhad.example.composition_inheritance.step1;

public interface Service<T> {
	String generateId();

	T save(T t);
}
