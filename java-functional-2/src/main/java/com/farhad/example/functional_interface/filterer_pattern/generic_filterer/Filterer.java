package com.farhad.example.functional_interface.filterer_pattern.generic_filterer;

import java.util.function.Predicate;

@FunctionalInterface
public interface Filterer<G, E> {
	G by(Predicate<? super E> predicate);

}
