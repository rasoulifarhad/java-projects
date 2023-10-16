package com.farhad.example.design_principles02.good_code.ocp;

public class Util {
	
	public static void isTrue(boolean b, String message, Object... args) {
		if(!b){
			throw new RuntimeException(String.format(message, args)); 
		}
	}
}
