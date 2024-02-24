package com.farhad.example.design_principles02.parking_lot.parking;

import lombok.Getter;

@Getter
public class ExitPannel {

	private String id;

	
	public ExitPannel(String id) {
		this.id = id;
	}

	public boolean scanTicket() {
		return true;
	}

	public boolean processPayment() {
		return true;
	}
}
