package com.farhad.example.design_principles02.ocp.demo1.good;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class Rectangle extends Shape{
	
	private int w;
	private int h;
	@Override
	public int calculateArea() {
		System.out.println("Rectangle:");
		return h * w;
	}
}
