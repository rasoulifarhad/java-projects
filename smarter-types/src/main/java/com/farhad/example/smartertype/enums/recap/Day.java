package com.farhad.example.smartertype.enums.recap;

import com.farhad.example.smartertype.util.Check;

public record Day(int n) {
	
	public Day {
		Check.range(0 < n && n <=31, this);
	}
}
