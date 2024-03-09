package com.farhad.example.another_bridge.demo1;

public class Client {

	public static void main(String[] args) {
		
		Implementor implementorA = new ConcreteImplementorA();
		Implementor implementorB = new ConcreteImplementorB();

		Abstraction abstractionA = new RefinedAbstraction(implementorA);
		abstractionA.operation();

		Abstraction abstractionB = new RefinedAbstraction(implementorB);
		abstractionB.operation();
	}
}
