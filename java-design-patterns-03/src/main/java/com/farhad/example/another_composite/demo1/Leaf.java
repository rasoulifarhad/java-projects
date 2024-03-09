package com.farhad.example.another_composite.demo1;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Leaf implements Component {

	private final String name;

	@Override
	public void operation() {
		System.out.println("Leaf: " + name + " -- Operation performed");
	}

}
