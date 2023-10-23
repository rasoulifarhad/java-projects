package com.farhad.example.design_principles02.lsp.demo1.bad;

public class Navigator {
	
	public void move(Vehicle vehicle) {

		vehicle.goForward();
		vehicle.turnLeft();
		vehicle.goForward();
		vehicle.turnRight();
		vehicle.goForward();
	}
}
