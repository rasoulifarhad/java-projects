package com.farhad.example.design_principles02.lsp.demo1.good;

public class Navigator {
	
	public void move(RoadVehicle vehicle) {

		vehicle.goForward();
		vehicle.turnLeft();
		vehicle.goForward();
		vehicle.turnRight();
		vehicle.goForward();
	}

	public void move(RailVehicle vehicle) {

		vehicle.goForward();
		vehicle.reverse();
		vehicle.reverse();
		vehicle.goForward();
	}

	public static void main(String[] args) {
		
		Navigator navigator = new Navigator();

		navigator.move(new Car("Car"));
		navigator.move(new Train("Train"));
	}

}
