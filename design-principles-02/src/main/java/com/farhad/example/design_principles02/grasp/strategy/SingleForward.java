package com.farhad.example.design_principles02.grasp.strategy;

public class SingleForward implements MovementBehaviour {

	@Override
	public String move() {
		System.out.println("move one step forward");
		return "move one step forward";
	}

}
