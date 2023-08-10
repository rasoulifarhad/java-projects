package com.farhad.example.designpatterns.specification.property;

public enum Movement {
	WALKING("Walking"),
	SWIMMING("Swimming"),
	FLYING("Flaying"); 

	private String title;

	private Movement(String title) {
		this.title = title;
	}

	public String toString() {
		return title;
	}
}
