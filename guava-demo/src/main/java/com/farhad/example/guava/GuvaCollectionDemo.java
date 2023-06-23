package com.farhad.example.guava;

import com.google.common.base.Function;

public class GuvaCollectionDemo {
    
    static class ParentType {}
    static class ChildType extends ParentType {}

    static class CastFunction<F, T extends F> implements Function<F, T> {

        @Override
        public T apply(F from) {
            return (T) from;
        }
    }
}
