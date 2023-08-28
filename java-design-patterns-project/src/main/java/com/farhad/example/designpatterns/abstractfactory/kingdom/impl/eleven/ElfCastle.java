package com.farhad.example.designpatterns.abstractfactory.kingdom.impl.eleven;

import com.farhad.example.designpatterns.abstractfactory.kingdom.Castle;

public class ElfCastle implements Castle {

	static final String DESCRIPTION = "This is the elven castle!";
	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
	
}
