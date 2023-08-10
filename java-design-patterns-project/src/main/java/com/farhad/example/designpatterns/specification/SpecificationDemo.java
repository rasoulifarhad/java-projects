package com.farhad.example.designpatterns.specification;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import com.farhad.example.designpatterns.specification.creature.Creature;
import com.farhad.example.designpatterns.specification.creature.Dragon;
import com.farhad.example.designpatterns.specification.creature.Goblin;
import com.farhad.example.designpatterns.specification.creature.KillerBee;
import com.farhad.example.designpatterns.specification.creature.Octopus;
import com.farhad.example.designpatterns.specification.creature.Shark;
import com.farhad.example.designpatterns.specification.creature.Troll;
import com.farhad.example.designpatterns.specification.property.Color;
import com.farhad.example.designpatterns.specification.property.Mass;
import com.farhad.example.designpatterns.specification.selector.ColorSelector;
import com.farhad.example.designpatterns.specification.selector.MassGreaterThanSelector;

public class SpecificationDemo {
	

	public static void main(String[] args) {
		
		List<Creature> creatures = Arrays.asList(
			new Dragon(),
			new Troll(),
			new Goblin(),
			new KillerBee(),
			new Shark(),
			new Octopus()
		);

		List<Creature> redCreatures = creatures.stream()
											.filter(new ColorSelector(Color.RED)) 
											.collect(toList());
		System.out.println(redCreatures);

		List<Creature> heavyCreatures = creatures.stream()
											.filter(new MassGreaterThanSelector(Mass.of(500.0)))
											.collect(toList());
		System.out.println(heavyCreatures);
	}
}
