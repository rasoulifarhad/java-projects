package com.farhad.example.designpatterns.abstractfactory.kingdom.impl.orcish;

import com.farhad.example.designpatterns.abstractfactory.kingdom.Castle;

public class OrcCastle implements Castle {
	
	static final String DESCRIPTION = "This is the orcish castle!";

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

}
