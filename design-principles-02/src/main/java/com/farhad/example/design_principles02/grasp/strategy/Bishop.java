package com.farhad.example.design_principles02.grasp.strategy;

public class Bishop extends Character {

	public Bishop() {
		super(new DiagonalMovement());
	}
}
