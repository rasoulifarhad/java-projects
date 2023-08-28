package com.farhad.example.designpatterns.abstractfactory.kingdom.impl.eleven;

import com.farhad.example.designpatterns.abstractfactory.kingdom.King;

public class ElfKing implements King {

	static final String DESCRIPTION = "This is the elven king!";
	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
	
}
