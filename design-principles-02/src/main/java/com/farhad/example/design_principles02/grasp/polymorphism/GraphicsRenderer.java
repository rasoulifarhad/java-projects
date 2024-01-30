package com.farhad.example.design_principles02.grasp.polymorphism;

import java.util.List;

public class GraphicsRenderer {

	public void render(List<Shape> shapes) {
		shapes.forEach(shape -> shape.draw() );
	}
}
