package com.farhad.example.OOADP_Lab.adapter;

public class AdapterDemo {

	public static void main(String[] args) {
		CalcTax ct = new MauriTaxAdapter();
		Item item = new Item("cycle", 2, 100, ct);
		item.displayItem();

		item.setCt(new GST());
		item.displayItem();
	}
}
