package com.farhad.example.annotation.demo02;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RuTests {

	public static void main(String[] args) throws Exception {
		
		int tests = 0;
		int passed = 0;

		Class<?> testClass = Class.forName("com.farhad.example.annotation.demo02.Sample");
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(ExceptionTest.class)) {
				tests++;
				try {
					m.invoke(null);
					System.out.printf("Test %s failed: no exception%n", m)	;
				} catch (InvocationTargetException wrappedEx) {
					Throwable throwable = wrappedEx.getCause();
					Class<? extends Throwable> expType = m.getAnnotation(ExceptionTest.class).value();
					if (expType.isInstance(throwable)) {
						passed++;
					} else {
						System.out.printf("Test %s failed: expected %s , got %s%n", m, expType.getName(), throwable);
					}
				} catch (Exception ex) {
					System.out.println("Invalid @Test: " + m);
				}
			}
		}
		System.out.println(String.format("Passed: %d, Failed: %d%n", passed, tests - passed));
	}
}
