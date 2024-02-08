package com.farhad.example.design_principles02.parallel_inheritance_hierarchies.bad;

public class CivilMileStone  implements MileStone {

	@Override
	public String work() {
		return "Create  Twin Towers";
	}

	@Override
	public String target() {
		return "Has to be completed in 2 years";
	}

	@Override
	public String toString() {
		return "CivilMileStone [work()=" + work() + ", target()=" + target()
				+ "]";
	}

}
