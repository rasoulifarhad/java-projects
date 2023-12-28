package com.farhad.example.design_principles02.lsp.demo1.good;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class RailVehicle implements Movable, Nameable {

	final String name;
	float speed= 100f;
	
	@Override
	public void goForward() {
		System.out.println(name + ": go forward...");
	}

	@Override
	public void reverse() {
		System.out.println(name + ": reverse...");
	}
}
