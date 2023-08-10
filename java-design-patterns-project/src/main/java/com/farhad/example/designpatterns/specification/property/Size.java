package com.farhad.example.designpatterns.specification.property;

public enum Size {
	SMALL("Small"),
	NORMAL("Normal"),
	LARGE("Large");

	private String title;

	private Size(String title) {
		this.title = title;
	}

	public String toString() {
		return title;
	}
}
