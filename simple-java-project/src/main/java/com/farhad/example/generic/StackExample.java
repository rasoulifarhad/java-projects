package com.farhad.example.generic;

import java.util.HashSet;
import java.util.Set;

public class StackExample {
    
    static class EmptyStackException extends RuntimeException {}
    static class FullStackException extends RuntimeException {}
    static class Stack<E> {

        private E[] elements ;
        private int size = 0 ;
    
        @SuppressWarnings("unchecked")
        public Stack() {
            elements = (E[])new Object[10];
        }

        void push(E o) {
            if (size >= elements.length) {
                throw new FullStackException();
            }
            elements[size++] = o ;
        }

        E pull() {
            if (size == 0 ) {
                throw new EmptyStackException();
            }
            E res = elements[--size];
            elements[size] = null;
            return res ;
        }
    }

    static class AnotherStack<E> {

        private Object[] elements ;
        private int size = 0 ;
    
        public AnotherStack() {
            elements = new Object[10];
        }

        void push(E o) {
            if (size >= elements.length) {
                throw new FullStackException();
            }
            elements[size++] = o ;
        }

        @SuppressWarnings("unchecked")
        E pull() {
            if (size == 0 ) {
                throw new EmptyStackException();
            }
            E res = (E) elements[--size];
            elements[size] = null;
            return res ;
        }
    }

    static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> res = new HashSet<>(s1);
        res.addAll(s2);
        return res;
    }

    
}
