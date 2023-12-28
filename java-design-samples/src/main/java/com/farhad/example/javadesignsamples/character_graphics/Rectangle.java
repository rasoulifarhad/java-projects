package com.farhad.example.javadesignsamples.character_graphics;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * draw a rectangle: 
 * 
 * 1. draw the top line
 * 2. draw the sid lines
 * 3. draw the bottom line
 */
@AllArgsConstructor

public class Rectangle extends ShapeBasics implements RectangleInterface {

	@Getter
	private int height;

	@Getter
	private int width;

	public Rectangle() {
		super();
		this.height = 0;
		this.width = 0;
	}
	public Rectangle(int offset, int height, int width) {
		super(offset);
		this.height = height;
		this.width = width;
	}

	@Override
	public void set(int newHeight, int newWidth) {
		this.height = newHeight;
		this.width = newHeight;
	}

		

	@Override
	public void drawHere() {
		
		drawHorizontalLine();
		drawSides();
		drawHorizontalLine();

	}

	// 1. display offset blank space
	// 2. display width copies of '-'
	// 3. System.out.println() 
	private void drawHorizontalLine() {
		skipSpaces(getOffset());
		for (int i = 0; i < width; i++) {
			System.out.print('-');
		}
		System.out.println();
	}

	private static void skipSpaces(int count) {
		for (int i = 0; i < count; i++) { 
			System.out.print(' ');
		}
	}

	private void drawSides() {

		for (int i = 0; i < height -2; i++) {
			drawOneLineOfSides();
		}
	}

	private void drawOneLineOfSides() {
		skipSpaces(getOffset());
		System.out.print('|');
		skipSpaces(getWidth() -2);
		System.out.print('|');
	}

	public static void main(String[] args) {
		
		RectangleInterface box = new Rectangle(5, 8, 4);
		box.drawHere();

		box.set(5, 5);
		box.setOffset(10);
		box.drawAt(2);
	}
	
}
