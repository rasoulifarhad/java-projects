package com.farhad.example.functional_interface.filterer_pattern.solution;

import java.util.function.Predicate;

import com.farhad.example.functional_interface.filterer_pattern.Group;
import com.farhad.example.functional_interface.filterer_pattern.Item;

@FunctionalInterface
public interface Filterer<G extends Group, E extends Item> {

	G by(Predicate<? super E> predicate);

}
