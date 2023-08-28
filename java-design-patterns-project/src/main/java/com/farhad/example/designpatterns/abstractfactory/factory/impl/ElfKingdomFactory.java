package com.farhad.example.designpatterns.abstractfactory.factory.impl;

import com.farhad.example.designpatterns.abstractfactory.factory.KingdomFactory;
import com.farhad.example.designpatterns.abstractfactory.kingdom.Army;
import com.farhad.example.designpatterns.abstractfactory.kingdom.Castle;
import com.farhad.example.designpatterns.abstractfactory.kingdom.King;
import com.farhad.example.designpatterns.abstractfactory.kingdom.impl.eleven.ElfArmy;
import com.farhad.example.designpatterns.abstractfactory.kingdom.impl.eleven.ElfCastle;
import com.farhad.example.designpatterns.abstractfactory.kingdom.impl.eleven.ElfKing;

public class ElfKingdomFactory implements KingdomFactory {

	@Override
	public Castle createCastle() {
		return new ElfCastle();
	}

	@Override
	public King createKing() {
		return new ElfKing();
	}

	@Override
	public Army createArmy() {
		return new ElfArmy();
	}
	
}
