package com.farhad.example.tools;

import lombok.ToString;

@ToString
public class Pair<F,S> {

    private final F f ;
    private final S s;

    private Pair(F f, S s) {
        this.f = f ;
        this.s = s ;
    }

    public static <F,S> Pair<F,S> of(F fst, S scnd) {
        return new Pair<F,S>(fst, scnd);
    }

}