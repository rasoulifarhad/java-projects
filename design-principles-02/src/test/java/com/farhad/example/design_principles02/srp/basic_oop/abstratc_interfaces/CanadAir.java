package com.farhad.example.design_principles02.srp.basic_oop.abstratc_interfaces;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CanadAir implements FireFighterPlane {

	private double consumption;
	private double autonomy;
	private int capacity;
	private Cargo cargo;

	
	@Override
	public void goTo(int distance, int load) {
		System.out.println("going to...");
		if (load > this.capacity) {
			return;
		}

		this.autonomy = this.autonomy - this.consumption * distance;
		System.out.println("Autonomy is down to: " + this.autonomy);

	}

	@Override
	public void comeBack() {
		System.out.println("Coming back...");
	}

	@Override
	public void dropWater() {
		System.out.println("Dropping water...");
	}

	@Override
	public void pickUpWater() {
		System.out.println("Picking up water...");
	}

	public void stopFire() {
		System.out.println("Stopping fire...");
	}
}
