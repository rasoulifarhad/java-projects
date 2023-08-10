package com.farhad.example.designpatterns.specification.selector;

import com.farhad.example.designpatterns.specification.creature.Creature;
import com.farhad.example.designpatterns.specification.property.Size;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SizeSelector implements AbstractSelector<Creature> {

	private final Size size;
	@Override
	public boolean test(Creature creature) {
		return creature.getSize().equals(size);
	}
	
}
