package com.farhad.example.design_principles02.parallel_inheritance_hierarchies.bad;

public class Manager {

	public static void main(String[] args) {
		
		Engineer computerEngineer = new ComputerEngineer();
		computerEngineer.setType("Computer Engineer");
		computerEngineer.setSalary(5000);
		computerEngineer.setMileStone(new ComputerMilrStone());

		Engineer civilEngineer = new CivilEngineer();
		civilEngineer.setType("Civil Engineer");
		civilEngineer.setSalary(6000);
		civilEngineer.setMileStone(new CivilMileStone());

		System.out.println(computerEngineer);
		System.out.println("------------------------------------");
		System.out.println(civilEngineer);
	}
}
