package com.farhad.example.design_principles02.srp.basic_oop.mixins_traits;

public interface AeroPlane {
	public static final String IS_A_CONSTANT = "constant";
	default void goTo(int distance, int load){
		System.out.println("going to...");
	}
	default  void comeBack(){
		System.out.println("Coming back...");		
	}
}
