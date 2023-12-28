package com.farhad.example.javadesignsamples.character_graphics;

import lombok.Getter;
import lombok.Setter;

public abstract class ShapeBasics  implements ShapeInterface {
	
	@Getter
	@Setter
	protected int offset;

	public ShapeBasics() {
		offset = 0;
	}

	public ShapeBasics(int offset) {
		this.offset = offset;
	}

	@Override
	public void drawAt(int lineNumber) {
		for (int i = 0; i < lineNumber; i++) {
			System.out.println();
		}
		drawHere();		
	}

	@Override
	public void drawHere() {
		for (int i = 0; i < offset; i++) {
			System.out.print(' ');
		}
		System.out.println('*');
	}

	

}
