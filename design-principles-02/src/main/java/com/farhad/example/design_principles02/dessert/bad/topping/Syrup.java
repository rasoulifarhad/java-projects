package com.farhad.example.design_principles02.dessert.bad.topping;

import lombok.Getter;

public class Syrup extends Topping {

	@Getter
	private String[] ingredients;
	
	public Syrup(String description, String [] ingredients) {
		super(description);
		this.ingredients = ingredients;
	}

	@Override
	public void serve() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'serve'");
	}

}
