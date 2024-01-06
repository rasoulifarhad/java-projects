package com.farhad.example.functional_interface.filterer_pattern.solution;

import java.util.List;
import java.util.function.Predicate;

import com.google.common.collect.ImmutableList;

import lombok.RequiredArgsConstructor;

// @Value
@RequiredArgsConstructor
// @Accessors(fluent = true)
public class PlainGroup implements Group {

	private final ImmutableList<PlainItem> items;

	@Override
	public List<? extends Item> items() {
		return items;
	}

	@Override
	public Filterer<? extends PlainGroup, ? extends PlainItem> filtered() {
		return predicate -> filteredGroup(predicate);
	}

	private PlainGroup filteredGroup(Predicate<? super PlainItem> predicate) {
		return new PlainGroup(filteredItems(predicate));
	}

	private ImmutableList<PlainItem> filteredItems(Predicate<? super PlainItem> predicate) {
		return this.items.stream()
				.filter(predicate)
				.collect(ImmutableList.toImmutableList());
	}
}
