package com.farhad.example.designpatterns.favorcompositionvsinheritance.inheritance;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

// See https://blogs.oracle.com/javamagazine/post/java-inheritance-composition
public class InstrumentedHashSetDemo {
	

	public static class InstrumentedHashSet<E> extends HashSet<E> {
		private int addCount = 0;

		public InstrumentedHashSet() {
		}

		public InstrumentedHashSet(int initialCapacity, float loadFactor) {
			super(initialCapacity, loadFactor);
		}

		@Override
		public boolean add(E e) {
			addCount++;
			return super.add(e);
		}

		@Override
		public boolean addAll(Collection<? extends E> c) {
			addCount += c.size();
			return super.addAll(c);
		}

		public int getAddCount() {
			return this.addCount;
		}
	}

	public static void main(String[] args) {
		InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
		s.addAll(Arrays.asList("One", "two", "Three"));
		System.out.println("Added count: " +  s.getAddCount());
	}
}
