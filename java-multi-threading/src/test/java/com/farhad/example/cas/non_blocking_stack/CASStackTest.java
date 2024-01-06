package com.farhad.example.cas.non_blocking_stack;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CASStackTest {

	private CASStack<Integer> stack;

	@BeforeEach
	public void setup() {
		stack = new CASStack<Integer>();
	}

	@AfterEach
	public void teardown() {
		stack = null;
	}

	@Test
	public void addToStackTest() {
		Node<Integer> newNode10 = new Node<Integer>(Integer.valueOf(10));
		stack.push(newNode10);

		Node<Integer> newNode9 = new Node<Integer>(Integer.valueOf(9));
		stack.push(newNode9);

	 	Node<Integer> popNode =  stack.pop();
		assertTrue(newNode9.equals(popNode));

	}
}
