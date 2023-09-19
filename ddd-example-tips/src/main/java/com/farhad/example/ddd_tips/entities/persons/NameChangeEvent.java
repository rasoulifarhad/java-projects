package com.farhad.example.ddd_tips.entities.persons;

import java.util.Objects;

import lombok.Getter;

@Getter
public class NameChangeEvent implements ChangeEvent {

	private final PersonName newName;
	
	public NameChangeEvent(PersonName name) {
		this.newName = Objects.requireNonNull(name);
	}

}
