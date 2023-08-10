package com.farhad.example.designpatterns.specification.selector;

import com.farhad.example.designpatterns.specification.creature.Creature;
import com.farhad.example.designpatterns.specification.property.Color;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ColorSelector extends AbstractSelector<Creature> {

	private final Color color;
	@Override
	public boolean test(Creature creature) {
		return creature.getColor().equals(color);
	}
	
}
