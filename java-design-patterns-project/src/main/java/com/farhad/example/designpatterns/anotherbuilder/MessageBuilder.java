package com.farhad.example.designpatterns.anotherbuilder;

public class MessageBuilder {

	private StringBuilder sb = new StringBuilder();

	public void append(String msg) {
		sb.append(msg).append("\n");
	}

	public int length() {
		return sb.length();
	}

	public String toString() {
		return sb.toString();
	}
}
