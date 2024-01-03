package com.farhad.example.functional_interface.filterer_pattern.better;

import java.util.List;
import java.util.function.Predicate;

import com.farhad.example.functional_interface.filterer_pattern.Item;
import com.farhad.example.functional_interface.filterer_pattern.ScoreExplanatoryItem;
import com.farhad.example.functional_interface.filterer_pattern.ScoredItem;

public interface ScoreExplanatoryGroup extends ScoredGroup {

	@Override
	List<? extends ScoreExplanatoryItem> items();

	ScoreExplanatoryGroup scoreExplanatoryFiltered(Predicate<? super ScoreExplanatoryItem> predicate);


	@Override
	default ScoreExplanatoryGroup scoreFiltred(Predicate<? super ScoredItem> predicate) {
		return scoreExplanatoryFiltered(predicate);
	}

	@Override
	default ScoreExplanatoryGroup filtered(Predicate<? super Item> predicate) {
		return scoreExplanatoryFiltered(predicate);
	}
}
