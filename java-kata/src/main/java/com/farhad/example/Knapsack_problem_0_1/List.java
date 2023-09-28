package com.farhad.example.Knapsack_problem_0_1;

import java.util.function.BiFunction;
import java.util.function.Function;

public abstract class List<A> {
    
    // Folding consists in taking a value of the intended result type (generally different 
    // from the elements type) and combining it with an element, then combining the result 
    // with the next element and so on until all elements have been processed.
    // We can fold a list starting from the left (the head of the list) or for the right 
    // (the last element of the list). To fold from the left, we use a left associative 
    // operation.
    // 
    // The z parameter is the starting result. It is called z by convention, meaning "zero", 
    // by analogy with the starting result for the sum of a list of integers.
    //
    // The operation used for the fold is represented by a BiFunction, taking an A (element 
    // of the list) and a B the current result) and returning a B (the next current result). 
    //
    // Cons(X1,Cons(X2,Cons(...(Cons(Xn,nil)))))
    // One can view a fold on lists as replacing  the nil at the end of the list with a 
    // specific value, and replacing each cons with a specific function.
    //
    // [1,2,3,4,5]
    // With a right fold, the sum would be parenthesized as 1 + (2 + (3 + (4 + 5))), 
    // whereas with a left fold it would be parenthesized as (((1 + 2) + 3) + 4) + 5. 
    //
    // In practice, it is convenient and natural to have an initial value which in the case 
    // of a right fold is used when one reaches the end of the list, and in the case of a 
    // left fold is what is initially combined with the first element of the list. In the 
    // example above, the value 0 (the additive identity) would be chosen as an initial 
    // value, giving 1 + (2 + (3 + (4 + (5 + 0)))) for the right fold, and 
    // ((((0 + 1) + 2) + 3) + 4) + 5 for the left fold. For multiplication, an initial choice 
    // of 0 wouldn't work: 0 * 1 * 2 * 3 * 4 * 5 = 0. The identity element for multiplication 
    // is 1. This would give us the outcome 1 * 1 * 2 * 3 * 4 * 5 = 120 = 5!. 
    // 
    // 
    // The abstract reasoning behind list consumers is this:
    //
    // - If I can do something to the first item in the list and the first item in the rest of the list
    // - Then I can do something to the whole list.
    //
    //   (1 2 3 4 5)       Here is my list.
    //   1   + (2 3 4 5)   I take the  first-item-of-the-list  and  the-rest-of-the-list.
    //   1+2 <-(_ 3 4 5)   I add  the-first-item-of-the-rest-of-the-list  to the initial first item.
    //   3   + (3 4 5)     This leaves me with a new  rest-of-the-list.
    //   6   + (4 5)       I do the same thing again.
    //   10  + (5)         And again.
    //   15  + ()          And again. Now I have no list left.
    //   15                Therefore, the sum is 15. (((1 +2) +3) +4) +5 = 15.
    // 
    //
    // Fold-left can be considered as operating on the list from the left:
    // 
    //   foldl + 0 (1 2 3)
    //   ((0 + 1) + 2) + 3
    //   (1 + 2) + 3
    //   3 + 3
    //   6
    // 
    // Fold-right works from the opposite end:
    // 
    //   foldr + 0 (1 2 3)
    //   ((0 + 3) + 2) + 1
    //   (3 + 2) + 1
    //   5 + 1
    //   6
    // 
    // There are two things to notice here. First, foldl works left-to-right, while foldr 
    // works in reverse. The second is the order in which our initial value was combined 
    // with the list. In both cases, the initial value was the first value, and the 
    // appropriate end of the list was the second.
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
