package com.farhad.example.designpatterns.specification.selector;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.farhad.example.designpatterns.specification.creature.Creature;
import com.farhad.example.designpatterns.specification.property.Movement;

public class MovementSelectorTest {

	@Test
	public void testMovement() {

		final Creature swimmingCreature = mock(Creature.class);
		when(swimmingCreature.getMovement()).thenReturn(Movement.SWIMMING);

		final Creature flyingCreature = mock(Creature.class);
		when(flyingCreature.getMovement()).thenReturn(Movement.FLYING);

		final MovementSelector swimmingSelector = new MovementSelector(Movement.SWIMMING);
		assertTrue(swimmingSelector.test(swimmingCreature));
		assertFalse(swimmingSelector.test(flyingCreature));  
	}
}
