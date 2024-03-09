package com.farhad.example.another_bridge.demo2;

public class VectorRenderer implements Renderer {

	@Override
	public void renderCircle() {
		System.out.println("Rendering Circle in Vector format");
	}

	@Override
	public void renderSquare() {
		System.out.println("Rendering Square in Vector format");
	}

}
