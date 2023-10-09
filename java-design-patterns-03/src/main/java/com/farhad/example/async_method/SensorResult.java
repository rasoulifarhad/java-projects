package com.farhad.example.async_method;

public interface SensorResult<T> {
	
	boolean isPresent();
	void setResult(T value);
	T getResult();

	void await();
	void addException(Throwable e);
	void printExceptions();
}
