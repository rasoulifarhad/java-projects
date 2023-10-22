package com.farhad.example.design_principles02.ocp.demo1.good;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class Circle extends Shape {
	int radius;

	@Override
	public int calculateArea() {
		System.out.println("Circle:");
		return (int)(radius * radius * Math.PI);
	}
}
