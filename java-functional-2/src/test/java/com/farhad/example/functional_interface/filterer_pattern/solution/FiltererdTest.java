package com.farhad.example.functional_interface.filterer_pattern.solution;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.common.collect.ImmutableList;

public class FiltererdTest {

	@Test
	public void testFiltered() {

		// Given
		PlainItem _a = new PlainItem("a");
		PlainItem _b = new PlainItem("b");
		PlainItem _ab = new PlainItem("ab");

		ImmutableList<PlainItem> items = ImmutableList.of(
				_a,
				_b,
				_ab);

		PlainGroup group = new PlainGroup(items);

		// When
		PlainGroup filteredGroup = group.filtered().by(item -> item.name().startsWith("a"));

		// Then
		assertThat(filteredGroup.items().size()).isEqualTo(2);
		assertTrue(filteredGroup.items().contains(_a));
	}
	
	@Test
	public void testFilteredByName() {
		// Given
		PlainItem _a = new PlainItem("a");
		PlainItem _b = new PlainItem("b");
		PlainItem _ab = new PlainItem("ab");

		ImmutableList<PlainItem> items = ImmutableList.of(
				_a,
				_b,
				_ab);

		PlainGroup group = new PlainGroup(items);

		// When
		PlainGroup filteredGroup = group.filtered().byName("ab");

		// Then
		assertThat(filteredGroup.items().size()).isEqualTo(1);
		assertTrue(filteredGroup.items().contains(_ab));

	}
}
