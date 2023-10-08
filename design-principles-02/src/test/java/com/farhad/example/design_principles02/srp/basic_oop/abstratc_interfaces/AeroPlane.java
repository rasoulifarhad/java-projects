package com.farhad.example.design_principles02.srp.basic_oop.abstratc_interfaces;

public interface AeroPlane {
	public static final String IS_A_CONSTANT = "constant";
	void goTo(int distance, int load);
	void comeBack();
}
