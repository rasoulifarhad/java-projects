package com.farhad.example.functional_interface.filterer_pattern.solution;

import java.util.function.Predicate;

@FunctionalInterface
public interface Filterer<G extends Group, E extends Item> {

	G by(Predicate<? super E> predicate);

	default G byName(String name) {
		return by(item -> item.name().equals(name) );
	}
}
