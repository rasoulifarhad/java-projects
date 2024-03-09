package com.farhad.example.another_bridge.demo2;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Shape {

	protected final Renderer renderer;

	abstract public void draw();
}
