package com.farhad.example.design_principles02.grasp.strategy;

public class DiagonalMovement implements MovementBehaviour {

	@Override
	public String move() {
		System.out.println("Moving Diagonally");
		return "Moving Diagonally";
	}

}
