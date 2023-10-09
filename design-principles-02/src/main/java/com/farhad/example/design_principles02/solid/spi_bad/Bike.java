package com.farhad.example.design_principles02.solid.spi_bad;

public class Bike implements Vehicle{

	private boolean moving;
	@Override
	public void sevMove(boolean moving) {
		this.moving = moving;
	}

	@Override
	public boolean engineOn() {
		throw new IllegalStateException("not supported");
	}

	@Override
	public boolean pedalsMove() {
		return moving;
	}

}
