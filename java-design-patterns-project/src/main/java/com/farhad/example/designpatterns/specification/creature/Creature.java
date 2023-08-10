package com.farhad.example.designpatterns.specification.creature;

import com.farhad.example.designpatterns.specification.property.Color;
import com.farhad.example.designpatterns.specification.property.Mass;
import com.farhad.example.designpatterns.specification.property.Movement;
import com.farhad.example.designpatterns.specification.property.Size;

public interface Creature {
	String getName();
	Size getSize();
	Movement getMovement();
	Color getColor();
	Mass getMass();

}
