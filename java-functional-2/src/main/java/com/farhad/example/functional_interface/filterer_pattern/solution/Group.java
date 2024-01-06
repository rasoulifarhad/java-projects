package com.farhad.example.functional_interface.filterer_pattern.solution;

import java.util.List;

public interface Group {

	List<? extends Item> items();

	Filterer<?, ?> filtered();
}