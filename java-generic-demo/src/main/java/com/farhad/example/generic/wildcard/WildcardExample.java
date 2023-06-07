package com.farhad.example.generic.wildcard;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WildcardExample {
    
    public static class A {}
    public static class B extends A {}
    public static class C extends A {}
    public static class B1 extends B {}
    public static class C1 extends C {}

    public static void main(String[] args) {
        List<A>  listA = new ArrayList<A>();
        List<B>  listB = new ArrayList<B>();

        // listA = listB;
        // listB = listA;

        List<?          > listUknown1 = new ArrayList<A>();
        List<? extends A> listUknown2 = new ArrayList<A>();
        List<? super   A> listUknown3 = new ArrayList<A>();

        wildcard();
    }

    static void wildcard() {
        List<Integer> list = new ArrayList<>();
        unsafeAdd(list, new Object());
    }
    static void wildcardAdd(List<?> list, Object object) {
        // list.add(object);   /// compile error
        list.add(null);
    }

    static  void unsafeAdd(List list, Object object) {
        list.add(object); 
    }
}
