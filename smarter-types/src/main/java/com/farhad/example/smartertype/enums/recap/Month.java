package com.farhad.example.smartertype.enums.recap;

import static com.farhad.example.smartertype.util.Check.range;

public enum Month {
	
	JANUARY(31),
	FEBRUARY(28),
	MARCH(31),
	APRIL(30),
	MAY(31),
	JUNE(30),
	JULY(31),
	AUGUST(31),
	SEPTEMBER(30),
	OCTOBER(31),
	NOVEMBER(30),
	DECEMBER(31),	
	NONE(0);

	
	final int maxDays;

	private Month(int maxDays) {
		this.maxDays = maxDays;
	}

	public static Month number(int n) {
		if (range(1 <= n && n <= 12, String.format("Month.number(%d)", n))) {
			return values()[n - 1 ];
		}
		return NONE;
	}

	public void checkDay(Day day) {
		range(day.n() <= maxDays, this + ": " + day);
	}
}
