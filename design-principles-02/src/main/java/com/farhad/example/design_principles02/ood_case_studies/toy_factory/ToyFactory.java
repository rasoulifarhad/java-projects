package com.farhad.example.design_principles02.ood_case_studies.toy_factory;

public class ToyFactory {
	public Toy getToy(String toyType) {
		if ("Dog".equals(toyType)) {
			return new Dog();
		} else if ("Cat".equals(toyType)) {
			return new Cat();
		} else {
			return null;
		}
	}
}
