package com.farhad.example.functional.try_success_failure;

@FunctionalInterface
public interface FailableSupplier<T> {
	public T get() throws Exception;
}
