package com.farhad.example.another_bridge.demo2;

public class RasterRenderer implements Renderer {

	@Override
	public void renderCircle() {
		System.out.println("Rendering Circle in Raster format");
	}

	@Override
	public void renderSquare() {
		System.out.println("Rendering Square in Raster format");
	}

}
