package com.farhad.example.factory_beverage_machine;

public class SalesMachine implements BeverageMachine {

	private static final int _soda = 111;
	private static final int _coffee = 222;
	private static final int _chocolate = 333;

	private int qtySold;
	private double valueSold;

	
	public SalesMachine() {
		qtySold = 0;
		valueSold = 0.0;
	}

	@Override
	public Beverage createBeverage(int typeOfBevrage) {
		switch (typeOfBevrage) {
			case 111:
				return new Soda(10.5, 0);
			case 222:
				return new Coffee(4.5, 0);
			case 333:
				return new Chocolate(6.5, 0);
			default:
				return null;
		}
	}

	@Override
	public void recordSale(Product product, int qty) {
		qtySold += qty;
		product.subtractInventory(qty);
		valueSold += (qty * product.getPrice());
	}

	@Override
	public void purchaseItemToSale(Product product, int qty, double priceSale) {
		product.addInventory(qty);
		product.setPrice(priceSale);
	}

	@Override
	public double getPriceTotalSold() {
		return valueSold;
	}

	@Override
	public int getQtyTotalSold() {
		return qtySold;
	}

}
