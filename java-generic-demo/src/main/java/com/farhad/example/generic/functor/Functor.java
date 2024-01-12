package com.farhad.example.generic.functor;

import java.util.function.Function;

public interface Functor<A> {

	<B> Functor<B> map(Function<A, B> f);
}
