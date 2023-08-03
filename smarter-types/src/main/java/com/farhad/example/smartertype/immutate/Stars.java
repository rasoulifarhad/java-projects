package com.farhad.example.smartertype.immutate;

import com.farhad.example.smartertype.util.Check;

public record Stars(int n) {
	public Stars { 
		Check.range(0 < n && n <=10, n);	
	}
}
