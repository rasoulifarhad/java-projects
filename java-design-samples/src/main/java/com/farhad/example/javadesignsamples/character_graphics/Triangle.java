package com.farhad.example.javadesignsamples.character_graphics;

import lombok.Getter;

public class Triangle extends ShapeBasics implements TriangleInterface {
	
	@Getter
	private int base;

	public Triangle() {
		super();
		this.base = 0;
	}

	public Triangle(int offset, int base) {
		super(offset);
		this.base = base;
	}

	@Override
	public void set(int newBase) {
		this.base = newBase;
	}

	@Override
	public void drawHere() {
		drawTop();
		drawBase();
	}

	private void drawBase() {
		skipSpaces(getOffset());
		for (int i = 0; i < base; i++) {
			System.out.print('*');
		}
		System.out.println();
	}

	private void drawTop() {
	}
	
	private static void skipSpaces(int count) {
		for (int i = 0; i < count; i++) { 
			System.out.print(' ');
		}
	}

}
