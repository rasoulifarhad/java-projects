package com.farhad.example.designpatterns.abstractfactory.factory;

import com.farhad.example.designpatterns.abstractfactory.kingdom.Army;
import com.farhad.example.designpatterns.abstractfactory.kingdom.Castle;
import com.farhad.example.designpatterns.abstractfactory.kingdom.King;

public interface KingdomFactory {
	
	Castle createCastle();
	King createKing();
	Army createArmy();

}
