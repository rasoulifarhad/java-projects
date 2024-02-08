package com.farhad.example.design_principles02.parallel_inheritance_hierarchies.bad;

import lombok.Data;

@Data
public class CivilEngineer implements Engineer {

	private String type;
	private int salary;
	private MileStone mileStone;

	@Override
	public String toString() {
		return "CivilEngineer [type=" + type + ", salary=" + salary
				+ ", mileStone=" + mileStone + "]";
	}

}
