package com.farhad.example.OOADP_Lab.adapter;

public class GST implements CalcTax {

	@Override
	public float taxAmount(int qty, float price) {
		return qty * price * 0.18f;
	}

}
