package com.farhad.example.design_principles02.grasp.strategy;

public class King extends Character {

	public King() {
		super(new SingleForward());
	}

}
