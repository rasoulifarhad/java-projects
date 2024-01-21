package com.farhad.example.design_principles02.enum_implementing_interface;

import com.farhad.example.design_principles02.enum_implementing_interface.common.Gender;

public class App {

	public static void main(String[] args) {
		
		Gender[] values = Gender.values();
		for (Gender gender : values) {
			System.out.println("Gender: value = " + gender.toString() + " display name = " + gender.getDisplayName());
		}
	}
}
