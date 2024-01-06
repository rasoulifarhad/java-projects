package com.farhad.example.functional_interface.filterer_pattern.generic_filterer;

import java.util.List;

public interface Group {
	List<? extends Item> items();

	Filterer<? extends Group, ? extends Item> filtered();
}
