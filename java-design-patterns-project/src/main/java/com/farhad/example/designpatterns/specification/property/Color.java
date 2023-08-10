package com.farhad.example.designpatterns.specification.property;

public enum Color {
	DARK("Dark"),
	LIGHT("Light"),
	GREEN("Green"),
	RED("Red");

	private String title;

	private Color(String title) {
		this.title = title;
	}

	public String toString() {
		return title;
	}
}
