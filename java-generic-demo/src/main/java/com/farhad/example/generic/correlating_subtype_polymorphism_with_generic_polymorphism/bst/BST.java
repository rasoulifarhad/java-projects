package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.bst;

public interface BST<E extends Comparable<? super E>> {

	void insert(E e);

	void delete(E e);

	void inorderPrint();

	boolean contains(E e);	

}