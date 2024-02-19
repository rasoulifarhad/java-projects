package com.farhad.example.design_principles02.time_billing;

import java.time.Instant;

public class TimeCard {

	private Instant date;
	private int hours;
	private Employee billingEmployee;
	private Client clientToBill;
}
