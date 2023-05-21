package com.farhad.example.refactoring.example01.after;

@FunctionalInterface
public interface Converter<T, R> {
    R serialize(T t);
}
