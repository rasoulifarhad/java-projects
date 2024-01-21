package com.farhad.example.generic.simple_list;

import java.util.ArrayList;
import java.util.List;

public class SimpleList<E> {

	private List<E> backingStore;

	public SimpleList() {
		backingStore = new ArrayList<E>();
	}

	public E add(E e) {
		if (backingStore.add(e)) {
			return e;
		} else {
			return null;
		}
	}

	public int size() {
		return backingStore.size();
	}

	public void clear() {
		backingStore.clear();
	}

	
}
