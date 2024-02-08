package com.farhad.example.design_principles02.parallel_inheritance_hierarchies.bad;

public class ComputerMilrStone implements MileStone {

	@Override
	public String work() {
		return "Build a Billing MicroService";
	}

	@Override
	public String target() {
		return "Has to be finshed in 14 PD";
	}

	@Override
	public String toString() {
		return "ComputerMileStone [work()=" + work() + ", target()=" + target()
				+ "]";
	}	
	
}
