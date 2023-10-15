package com.farhad.example.design_principles02.interfaces_protocols;

public class Car implements Drivable, Locatable{

	@Override
	public Coordinate getLocation() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getLocation'");
	}

	@Override
	public boolean locationIsValid() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'locationIsValid'");
	}

	@Override
	public double getSpeed() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getSpeed'");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'stop'");
	}
	
}
