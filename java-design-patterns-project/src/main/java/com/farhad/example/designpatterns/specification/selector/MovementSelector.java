package com.farhad.example.designpatterns.specification.selector;

import com.farhad.example.designpatterns.specification.creature.Creature;
import com.farhad.example.designpatterns.specification.property.Movement;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MovementSelector extends AbstractSelector<Creature> {

	private final Movement movement;

	@Override
	public boolean test(Creature creature) {
		return creature.getMovement().equals(movement);
	}
	
}
