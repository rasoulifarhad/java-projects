package com.farhad.example.another_adapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WildDogAdapter implements Lion {

	private final WildDog wildDog;
	@Override
	public void roar() {
		wildDog.bark();
	}

}
