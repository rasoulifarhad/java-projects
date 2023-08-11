package com.farhad.example.designpatterns.specification.creature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.farhad.example.designpatterns.specification.property.Color;
import com.farhad.example.designpatterns.specification.property.Mass;
import com.farhad.example.designpatterns.specification.property.Movement;
import com.farhad.example.designpatterns.specification.property.Size;

public class CreatureTest {

	public static Collection<Object[]> dataProvider() {
		return new ArrayList<Object[]>(){{
			add(new Object[] {new Dragon(), "Dragon", Size.LARGE, Movement.FLYING, Color.RED, Mass.of(39300.0)}) ;
			add(new Object[] {new Goblin(), "Goblin", Size.SMALL, Movement.WALKING, Color.GREEN, Mass.of(30.0)}) ;
		}};
	}

	@ParameterizedTest
	@MethodSource("dataProvider")
	public void testCreature(Creature testedCreature, String name, Size size, Movement movement,  Color color, Mass mass)  {
			assertEquals(name, testedCreature.getName());
			assertEquals(size, testedCreature.getSize());
			assertEquals(movement, testedCreature.getMovement());
			assertEquals(color, testedCreature.getColor());
			assertEquals(mass, testedCreature.getMass());
	}
}
