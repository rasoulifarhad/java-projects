package com.farhad.example.annotation.demo01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests {

	public static void main(String[] args) throws Exception {
		int tests = 0;
		int passed = 0;

		Class<?> testClass = Class.forName("com.farhad.example.annotation.demo01.Sample");
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(Test.class)) {
				tests++;
				try {
					m.invoke(null);
					passed++;
				} catch (InvocationTargetException ex) {
					Throwable throwable = ex.getCause();
					System.out.println(m + " fasiled:  " + throwable);
				} catch (Exception ex) {
					System.out.println("Invalid @Test: " + m);
				}
			}
		}
		System.out.println(String.format("Passed: %d, Failed: %d%n", passed, tests - passed));
	}
}
