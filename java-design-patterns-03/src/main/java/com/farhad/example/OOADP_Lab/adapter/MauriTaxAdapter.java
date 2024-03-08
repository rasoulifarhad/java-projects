package com.farhad.example.OOADP_Lab.adapter;

public class MauriTaxAdapter implements CalcTax{

	MauriTax mauriTax = new MauriTax();

	@Override
	public float taxAmount(int qty, float price) {
		return mauriTax.mauriTaxAmount(qty, price);
	}

}
