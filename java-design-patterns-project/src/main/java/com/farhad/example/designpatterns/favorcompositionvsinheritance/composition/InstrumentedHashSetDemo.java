package com.farhad.example.designpatterns.favorcompositionvsinheritance.composition;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// See https://blogs.oracle.com/javamagazine/post/java-inheritance-composition
public class InstrumentedHashSetDemo {
	
	public static class ForwardingSet<E> implements Set<E> {

		private final Set<E> s;
		

		public ForwardingSet(Set<E> s) {
			this.s = s;
		}


		@Override
		public int size() {
			return s.size();
		}


		@Override
		public boolean isEmpty() {
			return s.isEmpty();
		}


		@Override
		public boolean contains(Object o) {
			return s.contains(o);
		}


		@Override
		public Iterator<E> iterator() {
			return s.iterator();
		}


		@Override
		public Object[] toArray() {
			return s.toArray();
		}


		@Override
		public <T> T[] toArray(T[] a) {
			return s.toArray(a);
		}


		@Override
		public boolean add(E e) {
			return s.add(e);
		}


		@Override
		public boolean remove(Object o) {
			return s.remove(o);
		}


		@Override
		public boolean containsAll(Collection<?> c) {
			return s.containsAll(c);
		}


		@Override
		public boolean addAll(Collection<? extends E> c) {
			return s.addAll(c);
		}


		@Override
		public boolean retainAll(Collection<?> c) {
			return s.retainAll(c);
		}


		@Override
		public boolean removeAll(Collection<?> c) {
			return s.removeAll(c);
		}


		@Override
		public void clear() {
			s.clear();
		}


		@Override
		public int hashCode() {
			return s.hashCode();
		}


		@Override
		public boolean equals(Object obj) {
			return s.equals(obj);
		}


		@Override
		public String toString() {
			return s.toString();
		}
		
	}

	public static class InstrumentedSet<E> extends ForwardingSet<E> {
		
		private int addCount = 0;

		public InstrumentedSet(Set<E> s) {
			super(s);
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
			return addCount;
		}

	}

	public static void main(String[] args) {
		InstrumentedSet<String> s = new InstrumentedSet<>(new HashSet<>());
		s.addAll(Arrays.asList("One", "two", "Three"));
		System.out.println("Added count: " +  s.getAddCount());

	}
}
