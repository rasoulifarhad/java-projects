package com.farhad.example.functional_interface.basic.demo05;

public class App {

	public static void main(String[] args) {
		
		System.out.println(Multiply.DIRECTMUL.apply(2, 3));
		System.out.println(Multiply.OTHERMUL.apply(2, 3));
	}
}
