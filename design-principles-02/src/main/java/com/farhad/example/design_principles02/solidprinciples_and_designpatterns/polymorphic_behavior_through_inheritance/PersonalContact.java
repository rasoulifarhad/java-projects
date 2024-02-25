package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.polymorphic_behavior_through_inheritance;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonalContact extends Contact {

	private String address;
	private LocalDateTime birthDate;
	
	@Override
	public String getDetails() {
		return String.format("%s %s (%s)", getFirstName(), getLastName(),
				DateTimeFormatter.ofPattern("dd-MMM-yyyy").format(birthDate));
	}

	

}
