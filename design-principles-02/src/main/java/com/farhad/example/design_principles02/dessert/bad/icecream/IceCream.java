package com.farhad.example.design_principles02.dessert.bad.icecream;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class IceCream {

	@Getter
	private final String taste;

	public abstract void serve();
}
