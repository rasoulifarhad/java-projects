package com.farhad.example.functional_interface.filterer_pattern.issue_detector.s_1;

import java.util.function.Predicate;

@FunctionalInterface
public interface Filterer<T, I> {
	T by(Predicate<? super I> predicate);
}
