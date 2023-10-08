package com.farhad.example.design_principles02.srp.basic_oop.mixins_traits;

public interface FireFighterPlane extends AeroPlane {
	default void dropWater(){
		System.out.println("Dropping water...");
	}
	default void pickUpWater(){
		System.out.println("Picking up water...");
	}
}
