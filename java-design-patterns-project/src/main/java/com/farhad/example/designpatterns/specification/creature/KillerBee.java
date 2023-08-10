package com.farhad.example.designpatterns.specification.creature;

import com.farhad.example.designpatterns.specification.property.Color;
import com.farhad.example.designpatterns.specification.property.Mass;
import com.farhad.example.designpatterns.specification.property.Movement;
import com.farhad.example.designpatterns.specification.property.Size;

public class KillerBee extends AbstractCreature {

	public KillerBee() {
		this(Mass.of(6.7));
	}
	
	public KillerBee(Mass mass) {
		super("Killer Bee", Size.SMALL, Movement.FLYING, Color.LIGHT, mass);
	}
}
