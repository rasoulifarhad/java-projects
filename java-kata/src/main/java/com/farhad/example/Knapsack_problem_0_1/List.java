package com.farhad.example.Knapsack_problem_0_1;

import java.util.function.BiFunction;
import java.util.function.Function;

public abstract class List<A> {
    
    public abstract <B> B foldRight(B z, BiFunction<A, B, B> f);

    public List<A> cons(A a) {
        return new Cons<A>(a, this);
    }

    private static class Nil<A> extends List<A> {

        @Override
        public <B> B foldRight(B z, BiFunction<A, B, B> f) {
            return z;
        }
    }

    private static class Cons<A> extends List<A> {

        private final A head;
        private final List<A> tail;
 
        private Cons(A head, List<A> tail) {
            this.tail = tail;
            this.head = head;
        }

        @Override
        public <B> B foldRight(B z, BiFunction<A, B, B> f) {
            return f.apply(head, tail.foldRight(z, f));
        }

       
    }

    @SuppressWarnings("rawtypes")
    private static List NIL = new List.Nil();

    @SuppressWarnings("unchecked")
    public static <A> List<A> list() {
        return NIL;
    }

    public List<A> copy() {
        return foldRight(List.<A>list(), (a, list) -> list.cons(a) );
    }

    public <B> List<B> map(Function<A, B> f) {
        return foldRight(List.<B>list(), 
                    (a, list) -> list.cons(f.apply(a)));
    }

    public <B> List<B> flatMap(Function<A, List<B>> f) {
        return foldRight(List.<B>list(), 
                    (a, list) -> list.foldRight(f.apply(a), (a2, list2) -> list2.cons(a2)));
    }

    public List<A> concat(List<A> list) {
        return foldRight(list, (a, acc) -> acc.cons(a));
    }

    private int length() {
        return foldRight(0, (a, length) -> length + 1);
    }

    public List<A> head() {
        int length = this.length();
        return foldRight(
            List.<A>list(), 
            (a, list) -> length - list.length() != 1 ? 
                                        this.cons(a) :  
                                        List.<A>list().cons(a));
    }

    public List<List<A>> tail() {
        int length = this.length();
        return new Cons<>(foldRight(list(), (a, list) -> length - list.length() == 1
            ? list
            : list.cons(a)), list());        
    }

}
