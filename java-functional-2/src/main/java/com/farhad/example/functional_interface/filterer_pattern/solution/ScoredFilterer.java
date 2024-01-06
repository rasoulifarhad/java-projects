package com.farhad.example.functional_interface.filterer_pattern.solution;

@FunctionalInterface
public interface ScoredFilterer<G extends ScoredGroup, E extends ScoredItem> extends Filterer<G, E> {

	default G byMinScore(int minScore) {
		return by(item -> item.score() >= minScore);
	}
}
