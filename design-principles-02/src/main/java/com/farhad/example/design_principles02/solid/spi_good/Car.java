package com.farhad.example.design_principles02.solid.spi_good;

public class Car implements Vehicle, HasEngine {

	private boolean moving;
	@Override
	public void sevMove(boolean moving) {
		this.moving = moving;
	}

	@Override
	public boolean engineOn() {
		return moving;
	}
	
}
