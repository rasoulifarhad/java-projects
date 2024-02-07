package com.farhad.example.factory_beverage_machine;

public interface BeverageMachine {

	public Beverage createBeverage(int typeOfBevrage);

	public void recordSale(Product product, int qty);

	public void purchaseItemToSale(Product product, int qty, double priceSale);

	public double getPriceTotalSold();

	public int getQtyTotalSold();
}
