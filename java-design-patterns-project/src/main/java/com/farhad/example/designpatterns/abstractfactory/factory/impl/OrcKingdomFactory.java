package com.farhad.example.designpatterns.abstractfactory.factory.impl;

import com.farhad.example.designpatterns.abstractfactory.factory.KingdomFactory;
import com.farhad.example.designpatterns.abstractfactory.kingdom.Army;
import com.farhad.example.designpatterns.abstractfactory.kingdom.Castle;
import com.farhad.example.designpatterns.abstractfactory.kingdom.King;
import com.farhad.example.designpatterns.abstractfactory.kingdom.impl.orcish.OrcArmy;
import com.farhad.example.designpatterns.abstractfactory.kingdom.impl.orcish.OrcCastle;
import com.farhad.example.designpatterns.abstractfactory.kingdom.impl.orcish.OrcKing;

public class OrcKingdomFactory implements KingdomFactory {

	@Override
	public Castle createCastle() {
		return new OrcCastle();
	}

	@Override
	public King createKing() {
		return new OrcKing();
	}

	@Override
	public Army createArmy() {
		return new OrcArmy();
	}
	
}
