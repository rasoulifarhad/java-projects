package com.farhad.example.designpatterns.specification.creature;

import com.farhad.example.designpatterns.specification.property.Color;
import com.farhad.example.designpatterns.specification.property.Mass;
import com.farhad.example.designpatterns.specification.property.Movement;
import com.farhad.example.designpatterns.specification.property.Size;

public class Goblin extends AbstractCreature {
	public Goblin() {
		this(Mass.of(30.));
	}

	public Goblin(Mass mass) {
		super("Goblin", Size.SMALL, Movement.WALKING, Color.GREEN, mass);
	}
}
