package com.farhad.example.functional_interface.filterer_pattern.solution;

import java.util.List;


public interface ScoredGroup extends Group {

	@Override
	List<? extends ScoredItem> items();

	@Override
	Filterer<? extends ScoredGroup, ? extends ScoredItem> filtered();
}
