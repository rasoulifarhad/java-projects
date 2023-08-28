package com.farhad.example.designpatterns.abstractfactory.kingdom.impl.orcish;

import com.farhad.example.designpatterns.abstractfactory.kingdom.King;

public class OrcKing implements King {
	
	static final String DESCRIPTION = "This is the orcish king!";

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

}
