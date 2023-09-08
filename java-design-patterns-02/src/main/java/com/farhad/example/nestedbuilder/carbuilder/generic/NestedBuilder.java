package com.farhad.example.nestedbuilder.carbuilder.generic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class NestedBuilder<T, V> {
	
	protected T parent;

	public abstract V build();

	public T done() {
		Class<?> parentClass = parent.getClass();
		try {
			V build = build();
			String methodName = "with" + build.getClass().getSimpleName();
			Method method = parentClass.getDeclaredMethod(methodName,build.getClass());
			method.invoke(parent,build);
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return parent;
	}

	public <P extends NestedBuilder<T, V>> P withParentBuilder(T parent) {
		this.parent = parent;
		return (P) this;
	}	

}
