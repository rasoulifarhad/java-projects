
package com.farhad.example.design_principles02.parking_lot;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Person {

	private String name;
	private Location address;
	private String email;
	private String phoine;
}
