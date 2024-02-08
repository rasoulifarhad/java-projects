package com.farhad.example.design_principles02.parallel_inheritance_hierarchies.bad;

import lombok.Data;

@Data
public class ComputerEngineer implements Engineer {

	private String type;
	private int salary;
	private MileStone mileStone;

	@Override
	public String toString() {
		return "ComputerEngineer [type=" + type + ", salary=" + salary
				+ ", mileStone=" + mileStone + "]";
	}	
}
