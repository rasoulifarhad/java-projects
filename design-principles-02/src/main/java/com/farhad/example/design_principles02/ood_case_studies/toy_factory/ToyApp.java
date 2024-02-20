package com.farhad.example.design_principles02.ood_case_studies.toy_factory;

public class ToyApp {
	public static void main(String[] args) {
		ToyFactory tf = new ToyFactory();

		Toy toy;

		toy = tf.getToy("Dog");
		toy.talk();

		toy = tf.getToy("Cat");
		toy.talk();
	}
}
