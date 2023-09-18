package com.farhad.example.design_principles02.srp.basic_oop.encapsulation;

public class Animal {
	private String name;
	private double averageWeight;
	private int numberOfLegs;
	public String getName() {
		return name;
	}
	public double getAverageWeight() {
		return averageWeight;
	}
	public int getNumberOfLegs() {
		return numberOfLegs;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAverageWeight(double averageWeight) {
		this.averageWeight = averageWeight;
	}
	public void setNumberOfLegs(int numberOfLegs) {
		this.numberOfLegs = numberOfLegs;
	}
	
	
	public static void main(String[] args) {
		Animal animal = new Animal();

		animal.setName("Eagle");
		animal.setAverageWeight(1.5);
		animal.setNumberOfLegs(2);

		System.out.println("Name: " + animal.getName());
		System.out.println("Average weight: " + animal.getAverageWeight() + "kg");
		System.out.println("Number of legs: " + animal.getNumberOfLegs());
	}
}
