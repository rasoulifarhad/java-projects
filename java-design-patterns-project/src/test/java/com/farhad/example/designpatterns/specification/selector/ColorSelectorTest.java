package com.farhad.example.designpatterns.specification.selector;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.farhad.example.designpatterns.specification.creature.Creature;
import com.farhad.example.designpatterns.specification.property.Color;

public class ColorSelectorTest {
	

	@Test
	public void testColor() {
		final Creature greenCreature =  mock(Creature.class);
		when(greenCreature.getColor()).thenReturn(Color.GREEN);	

		final Creature redCreature = mock(Creature.class);
		when(redCreature.getColor()).thenReturn(Color.RED);

		final ColorSelector greenSelector = new ColorSelector(Color.GREEN);
		assertTrue(greenSelector.test(greenCreature));
		assertFalse(greenSelector.test(redCreature));
	}
}
