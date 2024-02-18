package com.farhad.example.design_principles02.dessert.bad.topping;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Topping {

	@Getter
	private final String description;

	public abstract void serve();
}
