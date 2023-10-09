package com.farhad.example.design_principles02.solid.spi_good;

public class Bike implements Vehicle, HasPedals {

	private boolean moving;
	@Override
	public void sevMove(boolean moving) {
		this.moving = moving;
	}

	@Override
	public boolean pedalsMove() {
		return moving;
	}

}
