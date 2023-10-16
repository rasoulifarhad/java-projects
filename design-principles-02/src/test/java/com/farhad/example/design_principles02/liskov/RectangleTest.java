package com.farhad.example.design_principles02.liskov;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RectangleTest {

	@Test
	public void passingTest() {
		Rectangle rectangle = new Rectangle();
		chechAreaOfRectangle(rectangle);
	}

	@Test
	public void failingTest() {
		SquareBad  square = new SquareBad();
		chechAreaOfRectangle(square);
	}

	private void chechAreaOfRectangle(Rectangle r) {
		r.setWidth(5);
		r.setHeight(2);
		assertThat(r.getWidth() * r.getHeight()).isEqualTo(10);
	}
}
