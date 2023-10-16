package com.farhad.example.design_principles02.liskov;

public class SquareBad extends Rectangle {
	
	public void setWidth(int width) {
		this.width = width;
		this.height = width;
	}

	public void setHeight(int height) {
		this.width = height;
		this.height = height;
	}

}
