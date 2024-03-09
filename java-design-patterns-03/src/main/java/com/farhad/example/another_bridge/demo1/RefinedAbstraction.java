package com.farhad.example.another_bridge.demo1;

public class RefinedAbstraction extends Abstraction {

	public RefinedAbstraction(Implementor implementor) {
		super(implementor);
	}

	@Override
	void operation() {
		System.out.print("Refined Abstraction -- ");
		implementor.implement();
	}

}
