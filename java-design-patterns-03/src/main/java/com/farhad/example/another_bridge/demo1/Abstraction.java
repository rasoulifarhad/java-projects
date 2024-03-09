package com.farhad.example.another_bridge.demo1;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Abstraction {

	protected final Implementor implementor;

	abstract void operation();
}
