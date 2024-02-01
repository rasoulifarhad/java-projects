package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

public class ServicesFactory {

	private static ServicesFactory servicesFactory;

	private AccountingAdapter accountingAdapter;
	private InventoryAdapter inventoryAdapter;
	private TaxCalculatorAdapter taxCalculatorAdapter;

	public static synchronized ServicesFactory getInstance() {
		if(servicesFactory == null ) {
			servicesFactory = new ServicesFactory();
		}
		return servicesFactory;
	}
	public AccountingAdapter getAccountingAdapter() throws Exception {
		if (accountingAdapter == null) {
			String clazzName = System.getProperty("accounting.class.name");
			accountingAdapter = (AccountingAdapter) Class.forName(clazzName).newInstance();
		}
		return accountingAdapter;
	}

	public InventoryAdapter getInventoryAdapter() throws Exception{

		if( inventoryAdapter == null ) {
			String clazzName = System.getProperty("inventory.class.name");
			inventoryAdapter = (InventoryAdapter) Class.forName(clazzName).newInstance();
		}
		return inventoryAdapter;
	}

	public TaxCalculatorAdapter getTaxCalculatorAdapter() throws Exception {
		if (taxCalculatorAdapter == null) {
			String clazzName = System.getProperty("taxCalculator.class.name");
			taxCalculatorAdapter = (TaxCalculatorAdapter) Class.forName(clazzName).newInstance();
		}
		return taxCalculatorAdapter;
	}
}
