package com.farhad.example.design_principles02.srp.basic_oop.inheritance;

public class Eagle extends Bird {
	public String name = "eagle";
	public int lifespan = 15;

	public static void main(String[] args) {
		Eagle eagle = new Eagle();

		System.out.println("Name: " + eagle.name);
		System.out.println("Reproduction: " + eagle.reproduction);
		System.out.println("Outer covering: " + eagle.outerCovering);
		System.out.println("Lifespan: " + eagle.lifespan);
		eagle.flyUp();
		eagle.flyDown();
	}
}
