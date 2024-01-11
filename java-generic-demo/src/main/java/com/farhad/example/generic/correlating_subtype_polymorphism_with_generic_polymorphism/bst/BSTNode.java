package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.bst;

public class BSTNode<T> {

	public T key;
	public BSTNode<T> left;
	public BSTNode<T> right;
	
	public BSTNode(T key) {
		this.key = key;
	}

	
}
