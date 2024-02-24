package com.farhad.example.design_principles02.polymorphic_behavior_through_inheritance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessContact extends Contact {
	private String companyName;
	private String designation;

	@Override
	public String getDetails() {
		return String.format("%s %s (%s, %s)", getFirstName(), getLastName(), designation, companyName);
	}

	
}
