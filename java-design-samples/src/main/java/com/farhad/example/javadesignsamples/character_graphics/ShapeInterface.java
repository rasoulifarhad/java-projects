package com.farhad.example.javadesignsamples.character_graphics;

/**
 * Interface for simple shapes drawn on the screen using keyboard characters
 */
public interface ShapeInterface {
	void setOffset(int newOffset);
	int getOffset();

	void drawAt(int lineNumber);
	void drawHere();
}
