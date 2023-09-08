package com.farhad.example.builder.laptop;

import lombok.Data;

// The product (Laptop) is the resulting object.
@Data
public class Laptop {

	private String info;

	public void info() {
		System.out.println(info);
	}
	
}
