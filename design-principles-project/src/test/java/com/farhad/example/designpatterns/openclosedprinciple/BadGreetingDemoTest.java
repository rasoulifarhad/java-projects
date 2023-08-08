package com.farhad.example.designpatterns.openclosedprinciple;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.farhad.example.designpatterns.openclosedprinciple.BadGreetingDemo.Greeter;

public class BadGreetingDemoTest {

	@Test
	public void testSayHelloFormality() {
		Greeter greeter = new Greeter();
		greeter.setFormality("formal");
		assertEquals("Good evening, sir.", greeter.greet());
		
	}
}
