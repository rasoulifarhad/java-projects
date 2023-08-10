package com.farhad.example.designpatterns.specification.selector;

import com.farhad.example.designpatterns.specification.creature.Creature;
import com.farhad.example.designpatterns.specification.property.Mass;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MassGreaterThanSelector extends AbstractSelector<Creature> {

	private final Mass mass;

	@Override
	public boolean test(Creature creature) {
		return creature.getMass().greaterThan(mass);
	}
	
}
