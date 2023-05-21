package com.farhad.example.raw;

import java.util.HashSet;
import java.util.Set;

public class StackExample {

    static class EmptyStackException extends RuntimeException {}
    static class FullStackException extends RuntimeException {}
    static class Stack {

        private Object[] elements ;
        private int size = 0 ;
    
        public Stack() {
            elements = new Object[10];
        }

        void push(Object o) {
            if (size >= elements.length) {
                throw new FullStackException();
            }
            elements[size++] = o ;
        }

        Object pull() {
            if (size == 0 ) {
                throw new EmptyStackException();
            }
            Object res = elements[--size];
            elements[size] = null;
            return res ;
        }
    }

    static class SetUtils {

        static Set union( Set s1, Set s2) {
            Set res = new HashSet(s1);
            res.addAll(s2);
            return res ;
        }
    }
}
