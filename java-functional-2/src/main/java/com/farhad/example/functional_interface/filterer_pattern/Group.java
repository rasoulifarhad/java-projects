package com.farhad.example.functional_interface.filterer_pattern;

import java.util.List;
import java.util.function.Predicate;

public interface Group {

	List<? extends Item> items();

	Group filtered(Predicate<? super Item> predicate);
}
