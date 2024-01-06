package com.farhad.example.cas.non_blocking_stack;

public class Node<T> {
	T value;
	Node<T> next;
	public Node(T value) {
		this.value = value;
		this.next = null;
	}

	
}
