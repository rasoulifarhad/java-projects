package com.farhad.example.design_principles02.lsp.demo1.bad;

public class Train extends Vehicle{

	public Train(String name) {
		super(name);
	}

	@Override
	public void turnLeft() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void turnRight() {
		throw new UnsupportedOperationException();
	}
	
}