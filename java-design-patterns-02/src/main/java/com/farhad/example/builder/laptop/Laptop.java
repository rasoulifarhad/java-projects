package com.farhad.example.builder.laptop;

import lombok.Data;

@Data
public class Laptop {

	private String info;

	public void info() {
		System.out.println(info);
	}
	
}
