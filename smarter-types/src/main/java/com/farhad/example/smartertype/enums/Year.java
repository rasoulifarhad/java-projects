package com.farhad.example.smartertype.enums;

import com.farhad.example.smartertype.util.Check;

public record Year(int n) {
	
	public Year {
		Check.range(1900 < n && n <= 2023,this);
	}
}
