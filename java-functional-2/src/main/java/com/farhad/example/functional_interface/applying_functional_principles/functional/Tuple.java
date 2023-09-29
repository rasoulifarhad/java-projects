package com.farhad.example.functional_interface.applying_functional_principles.functional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Tuple<T, U> {
    
    private final T _1;
    private final U _2;

    public T _1() {
        return _1;
    }
    public U _2() {
        return _2;
    }


}
