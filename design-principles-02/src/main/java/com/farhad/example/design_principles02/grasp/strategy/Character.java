package com.farhad.example.design_principles02.grasp.strategy;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Character {

	protected final MovementBehaviour movementBehaviour;

	public String move() {
		return movementBehaviour.move();
	}
}
