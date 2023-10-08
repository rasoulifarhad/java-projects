package com.farhad.example.design_principles02.srp.basic_oop.inheritance_polymorphism;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AeroPlane {

	private double consumption;
	private double autonomy;
	private int capacity;
	private Cargo cargo;

	public final void goTo(int distance, int load) {

		if (load > this.capacity) {
			return;
		}

		this.autonomy = this.autonomy - this.consumption * distance;
		System.out.println("Autonomy is down to: " + this.autonomy);
	}
}
