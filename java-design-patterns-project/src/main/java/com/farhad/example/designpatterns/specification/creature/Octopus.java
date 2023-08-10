package com.farhad.example.designpatterns.specification.creature;

import com.farhad.example.designpatterns.specification.property.Color;
import com.farhad.example.designpatterns.specification.property.Mass;
import com.farhad.example.designpatterns.specification.property.Movement;
import com.farhad.example.designpatterns.specification.property.Size;

public class Octopus extends AbstractCreature {

	public Octopus() {
		super("Octopus", Size.NORMAL, Movement.SWIMMING, Color.LIGHT, Mass.of(8980.0));
	}
	
}
