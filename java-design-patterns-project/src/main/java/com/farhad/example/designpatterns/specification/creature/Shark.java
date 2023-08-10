package com.farhad.example.designpatterns.specification.creature;

import com.farhad.example.designpatterns.specification.property.Color;
import com.farhad.example.designpatterns.specification.property.Mass;
import com.farhad.example.designpatterns.specification.property.Movement;
import com.farhad.example.designpatterns.specification.property.Size;

public class Shark extends AbstractCreature {

	public Shark() {
		this(Mass.of(500.0));
	}

	public Shark(Mass mass) {
		super("Shark", Size.LARGE, Movement.SWIMMING, Color.LIGHT, mass);
	}
	
}
