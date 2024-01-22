package com.farhad.example.functional_interface.design_patterns.template_method.standard_oop;

public class App {

	public static void main(String[] args) {
		AbstractClass class1 = new ClassA();
		class1.templateMethod();

		AbstractClass class2 = new ClassB();
		class2.templateMethod();
	}
}
