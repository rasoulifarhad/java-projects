package com.farhad.example.functional_interface.filterer_pattern.solution;

import java.util.List;


public interface ScoreExplanatoryGroup extends ScoredGroup {

	@Override
	List<? extends ScoreExplanatoryItem> items();

	@Override
	Filterer<? extends ScoreExplanatoryGroup, ? extends ScoreExplanatoryItem> filtered();
}
