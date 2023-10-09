package com.farhad.example.design_principles02.solid.spi_bad;

public class Car implements Vehicle {

	private boolean moving;
	@Override
	public void sevMove(boolean moving) {
		this.moving = moving;
	}

	@Override
	public boolean engineOn() {
		return moving;
	}

	@Override
	public boolean pedalsMove() {
		throw new IllegalStateException("not supported");
	}
	
}
