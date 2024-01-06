package com.farhad.example.cas.non_blocking_stack;

import java.util.concurrent.atomic.AtomicReference;

public class CASStack<T> {

	private AtomicReference<Node<T>> top = new AtomicReference<>();


	public void push(Node<T> newNode) {
		while (true) {
			Node<T> currentTop = top.get();
			newNode.next = currentTop;
			if(top.compareAndSet(currentTop, newNode)) {
				break;
			}
		}
	}

	public Node<T> pop() {
		while (true) {
			Node<T> currentTop = top.get();
			if (currentTop == null) {
				return null;
			}
			
			Node<T> newTop = currentTop.next;
			if(top.compareAndSet(currentTop, newTop)) {
				return currentTop;
			}
		}
	}
}
