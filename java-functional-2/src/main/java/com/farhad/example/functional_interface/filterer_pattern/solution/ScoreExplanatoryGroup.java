package com.farhad.example.functional_interface.filterer_pattern.solution;

import java.util.List;

import com.farhad.example.functional_interface.filterer_pattern.ScoreExplanatoryItem;

public interface ScoreExplanatoryGroup extends ScoredGroup {

	@Override
	List<? extends ScoreExplanatoryItem> items();

	@Override
	Filterer<? extends ScoreExplanatoryGroup, ? extends ScoreExplanatoryItem> filtered();
}
