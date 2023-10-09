package com.farhad.example.twin.vehicle;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractVehiclePart {

	@Setter(value = AccessLevel.PROTECTED)
	@Getter
	private boolean ready;

	protected AbstractVehiclePart() {
		System.out.println("AbstractVehiclePart, constructor");
	}

	abstract void init();

	
}
