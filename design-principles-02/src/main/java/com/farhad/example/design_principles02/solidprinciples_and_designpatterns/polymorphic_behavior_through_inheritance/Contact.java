package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.polymorphic_behavior_through_inheritance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contact {

	private String firstName;
	private String lastName;
	private String emailAddress;
	private String phoneNo;

	public String getDetails() {
		return String.format("%s %s (%s, %s)", firstName, lastName, emailAddress, phoneNo);
	}
}
