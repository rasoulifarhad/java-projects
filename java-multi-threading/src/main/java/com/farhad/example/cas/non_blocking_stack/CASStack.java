package com.farhad.example.cas.non_blocking_stack;

import java.util.concurrent.atomic.AtomicReference;

public class CASStack {

	private AtomicReference<Node<Integer>> top = new AtomicReference<>();


	public void push(Node<Integer> newNode) {
		while (true) {
			Node<Integer> currentTop = top.get();
			newNode.next = currentTop;
			if(top.compareAndSet(currentTop, newNode)) {
				break;
			}
		}
	}

	public Node<Integer> pop() {
		while (true) {
			Node<Integer> currentTop = top.get();
			if (currentTop == null) {
				return null;
			}
			
			Node<Integer> newTop = currentTop.next;
			if(top.compareAndSet(currentTop, newTop)) {
				return currentTop;
			}
		}
	}
}
