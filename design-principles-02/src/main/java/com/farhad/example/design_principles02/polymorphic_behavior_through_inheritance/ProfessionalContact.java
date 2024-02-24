package com.farhad.example.design_principles02.polymorphic_behavior_through_inheritance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessionalContact extends Contact {

	private String service;
	private String address;
	private String timing;

	@Override
	
	public String getDetails() {
		return String.format("%s %s (%s, %s)", getFirstName(), getLastName(), service, timing);
	}

	
}
