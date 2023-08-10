package com.farhad.example.designpatterns.specification;

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
import com.farhad.example.designpatterns.specification.property.Movement;
import com.farhad.example.designpatterns.specification.selector.AbstractSelector;
import com.farhad.example.designpatterns.specification.selector.ColorSelector;
import com.farhad.example.designpatterns.specification.selector.MassEqualsSelector;
import com.farhad.example.designpatterns.specification.selector.MassGreaterThanSelector;
import com.farhad.example.designpatterns.specification.selector.MovementSelector;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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

		log.info("Find RED creatures:");
		creatures.stream()
					.filter(new ColorSelector(Color.RED)) 
					.map(Object::toString)
					.forEach(log::info);

		log.info("Find Creatures greater than 500kg:");					
		creatures.stream()
					.filter(new MassGreaterThanSelector(Mass.of(500.0)))
					.map(Object::toString)
					.forEach(log::info);
		
		AbstractSelector<Creature> redAndFlying = new ColorSelector(Color.RED).and(new MovementSelector(Movement.FLYING));
		log.info("Find Red and Flying creatures:");
		creatures.stream()
					.filter(redAndFlying)
					.map(Object::toString)
					.forEach(log::info);

		log.info("Find all scary creatures:");
		AbstractSelector<Creature> scaryCreaturesSelector = new ColorSelector(Color.RED)
						.or(new ColorSelector(Color.RED))
						.and(new MovementSelector(Movement.SWIMMING).not())
						.and(new MassGreaterThanSelector(Mass.of(400.0)).or(new MassEqualsSelector(Mass.of(400.0))));
		creatures.stream()
					.filter(scaryCreaturesSelector)
					.map(Object::toString)
					.forEach(log::info);



	}
}
