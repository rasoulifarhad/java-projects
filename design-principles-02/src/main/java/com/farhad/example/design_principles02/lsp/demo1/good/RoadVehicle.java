package com.farhad.example.design_principles02.lsp.demo1.good;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class RoadVehicle implements Movable, Turnable ,Nameable{

	final String name;
	float speed = 100f;
	float turnSpeed = 5f;


	@Override
	public void goForward() {
		System.out.println(name + ": go forward...");
	}

	@Override
	public void reverse() {
		System.out.println(name + ": reverse...");
	}

	@Override
	public void turnRight() {
		System.out.println(name + ": turn right...");
	}

	@Override
	public void turnLeft() {
		System.out.println(name + ": turn left...");
	}

}
