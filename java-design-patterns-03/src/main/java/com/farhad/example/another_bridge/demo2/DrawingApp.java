package com.farhad.example.another_bridge.demo2;

public class DrawingApp {

	public static void main(String[] args) {
		Renderer vectorRenderer = new VectorRenderer();
		Renderer rasterRenderer = new RasterRenderer();

		Shape circle = new Circle(vectorRenderer);
		Shape square = new Square(rasterRenderer);

		circle.draw();
		square.draw();
	}
}
