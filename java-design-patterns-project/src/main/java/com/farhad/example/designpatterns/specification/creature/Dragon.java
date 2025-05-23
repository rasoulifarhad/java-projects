package com.farhad.example.designpatterns.specification.creature;

import com.farhad.example.designpatterns.specification.property.Color;
import com.farhad.example.designpatterns.specification.property.Mass;
import com.farhad.example.designpatterns.specification.property.Movement;
import com.farhad.example.designpatterns.specification.property.Size;

public class Dragon extends AbstractCreature {
	
	public Dragon() {
		this(Mass.of(39300.0));
	}

	public Dragon(Mass mass) {
		super("Dragon", Size.LARGE, Movement.FLYING, Color.RED, mass);
	}

}
