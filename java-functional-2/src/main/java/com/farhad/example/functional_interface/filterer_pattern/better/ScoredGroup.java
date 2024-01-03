package com.farhad.example.functional_interface.filterer_pattern.better;

import java.util.List;
import java.util.function.Predicate;

import com.farhad.example.functional_interface.filterer_pattern.Group;
import com.farhad.example.functional_interface.filterer_pattern.Item;
import com.farhad.example.functional_interface.filterer_pattern.ScoredItem;

public interface ScoredGroup extends Group {

	ScoredGroup scoreFiltred(Predicate<? super ScoredItem> predicate);

	@Override
	List<? extends ScoredItem> items();

	@Override
	default ScoredGroup filtered(Predicate<? super Item> predicate) {
		return scoreFiltred(predicate);
	}

}
