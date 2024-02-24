package com.farhad.example.design_principles02.parking_lot.parkingspot;

import java.time.Instant;

import com.farhad.example.design_principles02.parking_lot.payment.Payment;

public class ElectricPanel {

	private int payedForMinuts;
	private Instant chargingStartTime;
	private Payment payment;

	public boolean cancelCharging() {
		return true;
	}
}
