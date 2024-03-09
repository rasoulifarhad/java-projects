package com.farhad.example.another_bridge.demo2;

public class Square extends Shape {

	public Square(Renderer renderer) {
		super(renderer);
	}

	@Override
	public void draw() {
		System.out.print("Drawing Square -- ");
		renderer.renderSquare();
	}

}
