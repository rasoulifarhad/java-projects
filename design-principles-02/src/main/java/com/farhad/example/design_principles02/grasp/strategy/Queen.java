package com.farhad.example.design_principles02.grasp.strategy;

public class Queen extends Character {

	public Queen() {
		super(new SingleForward());
	}
}
