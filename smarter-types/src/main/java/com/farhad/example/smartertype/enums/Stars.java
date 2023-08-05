package com.farhad.example.smartertype.enums;

public enum Stars {
	ONE, TWO,THREE, FOUR, FIVE,
	SIX, SEVEN, EIGHT, NINE, TEN;

	final int n;

	Stars() {
		this.n = ordinal() + 1;
	}

	public static Stars index(int i) {
		return values()[i - 1];
	}

}
