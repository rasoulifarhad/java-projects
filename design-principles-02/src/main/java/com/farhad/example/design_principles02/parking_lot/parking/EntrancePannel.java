package com.farhad.example.design_principles02.parking_lot.parking;

import lombok.Getter;

@Getter
public class EntrancePannel {

	private String id;

	public EntrancePannel(String id) {
		this.id = id;
	}



	public boolean printTicket() {
		return true;
	}
}
