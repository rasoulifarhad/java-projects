package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.bst;

public class LinkedBST<E extends Comparable<? super E>> implements BST<E>{

	private BSTNode<E> root;

	/** Insert e into me, if it’s not already there. */

	@Override
	public void insert(E e) {
		root = LinkedBST.insert(root, e);
	}

	// If t is empty, replace t by a tree consisting of a single node with value e.
	// If t has e at its root, e is already in t. Return without modifying t.
	// If e is less than the value at the root of t, insert e into the left subtree of t.
	// If e is greater than the value at the root of t, insert e into the right subtree of t
	private static <T extends Comparable<? super T>> BSTNode<T> insert(BSTNode<T> t, T e) {
		if (t == null) {
			t = new BSTNode<T>(e);
		} else if(e.compareTo(t.key) < 0) {
			t.left = insert(t.left, e);
		} else if (e.compareTo(t.key) > 0) {
			t.right = insert(t.right, e);
		} // else equal, don’t do anything
		return t;
	}

	// Delete e from this BST, if it is there.
	@Override
	public void delete(E e) {
		root = LinkedBST.delete(root, e);
	}

	// Delete k from the tree rooted at t (if there) and return the root of the resulting tree.
	//
	// Find the node you wish to delete (if it is there).
	// If the node is a leaf, delete it.
	// If the node has exactly one child, delete the node by making its parent refer to that child directly
	// If the node has two children, replace the value in the node by the value in its successor and then delete the successor.
	private static <T extends Comparable<? super T>> BSTNode<T> delete(BSTNode<T> t, T e) {
		if (t == null) {
			
		} else if( e.compareTo(t.key) < 0 ) {
			t.left = delete(t.left, e);
		} else if (e.compareTo(t.key) > 0) {
			t.right = delete(t.right, e);
		} else {
			if (t.right == null) {
				// t has at most one child, on the left.
				t = t.left;
			} else {
				// t has a right child. Replace t’s value with its successor value.
				T successor = min(t.right);
				t.key = successor;
				t.right = delete(t.right, successor);
			}
		}
		return t;
	}

	// Return the minimum value in t.
	private static <T extends Comparable<? super T>> T min(BSTNode<T> t) {
		// To find the min, go left as far as possible.
		if (t.left == null) {
			return t.key;
		} else {
			return min(t.left);
		}
	}

	@Override
	public void inorderPrint() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'inorderPrint'");
	}

	@Override
	public boolean contains(E e) {
		return LinkedBST.contains(root, e);
	}

	private static <T extends Comparable<? super T>> boolean contains(BSTNode<T> t, T e) {
		if (t == null) {
			return false;
		} else if(e.compareTo(t.key) == 0) {
			return true;
		} else if(e.compareTo(t.key) < 0) {
			return contains(t.left, e);
		} else {
			return contains(t.right, e);
		}
	}
}
