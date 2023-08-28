package com.farhad.example.designpatterns.abstractfactory.kingdom.impl.eleven;

import com.farhad.example.designpatterns.abstractfactory.kingdom.Army;

public class ElfArmy implements Army{

	static final String DESCRIPTION = "This is the elven army!";

	@Override
	public String getDescription() {
		return DESCRIPTION; 
	}
	
}
