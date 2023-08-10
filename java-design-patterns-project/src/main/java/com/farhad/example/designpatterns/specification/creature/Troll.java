package com.farhad.example.designpatterns.specification.creature;

import com.farhad.example.designpatterns.specification.property.Color;
import com.farhad.example.designpatterns.specification.property.Mass;
import com.farhad.example.designpatterns.specification.property.Movement;
import com.farhad.example.designpatterns.specification.property.Size;

public class Troll extends AbstractCreature {
	
	public Troll() {
		this(Mass.of(4000.0));
	}

	public Troll(Mass mass) {
		super("Troll", Size.LARGE, Movement.WALKING, Color.DARK, mass);
	}

}
