package com.farhad.example.designpatterns.abstractfactory;

import com.farhad.example.designpatterns.abstractfactory.factory.FactoryMaker;
import com.farhad.example.designpatterns.abstractfactory.factory.FactoryMaker.KingdomType;
import com.farhad.example.designpatterns.abstractfactory.factory.KingdomFactory;
import com.farhad.example.designpatterns.abstractfactory.kingdom.Army;
import com.farhad.example.designpatterns.abstractfactory.kingdom.Castle;
import com.farhad.example.designpatterns.abstractfactory.kingdom.King;

import lombok.Getter;

// see https://java-design-patterns.com/patterns/abstract-factory/#explanation
@Getter
public class App {

	private Castle castle;
	private King king;
	private Army army;

	public void createKingdom(KingdomFactory kingdomFactory) {
		this.castle = kingdomFactory.createCastle();
		this.king = kingdomFactory.createKing();
		this.army = kingdomFactory.createArmy();
	}

	public static void main(String[] args) {
		
		App app = new App();
		app.createKingdom(FactoryMaker.makeFactory(KingdomType.ELF));
		System.out.println(app.getCastle().getDescription());
		System.out.println(app.getKing().getDescription());
		System.out.println(app.getArmy().getDescription());

		app.createKingdom(FactoryMaker.makeFactory(KingdomType.ORC)); 
		System.out.println(app.getCastle().getDescription());
		System.out.println(app.getKing().getDescription());
		System.out.println(app.getArmy().getDescription());

	}
}
