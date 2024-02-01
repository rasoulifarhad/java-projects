package com.farhad.example.design_principles02.grasp.creator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InvoiceItem {

	private String name;
	private int price;
}
