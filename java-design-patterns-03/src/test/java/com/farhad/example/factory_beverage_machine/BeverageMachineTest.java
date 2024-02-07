package com.farhad.example.factory_beverage_machine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BeverageMachineTest {

	@Test
	public void test() {

		int _soda = 111;
		int _coffee = 222;
		int _chocolate = 333;

		Product _prodSoda;
		Product _prodCoffee;
		Product _prodChocolate;

		BeverageMachine beverageMachine = new SalesMachine();

		Beverage beverage;

		beverage = beverageMachine.createBeverage(_soda);
		_prodSoda = beverage.getFullProduct();
		beverageMachine.purchaseItemToSale(_prodSoda, 121, 12.8);
		assertEquals("Soda", _prodSoda.getName());
	}
}


