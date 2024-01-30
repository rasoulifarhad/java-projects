package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.ItemId;
import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.Money;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Register {

	private final Store store;
	private final ProductCatalog productCatalog;
	private Sale currentSale = null;

	private AccountingAdapter accountingAdapter;

	public void makeNewSale() {
		this.currentSale = new Sale();
	}
	
	public void enterItem(ItemId itemId, int quantity) {
		ProductDescription pd = getProductDescription(itemId);
		currentSale.makeLineItem(pd, quantity);

	}

	public void endSale() {
		currentSale.complete();

	}
	
	public void makePayment(Money cashTendered ) {
		currentSale.makePayment(cashTendered);
		store.addCompleteSale(currentSale);
		accountingAdapter.postSale(currentSale);

	}

	private ProductDescription getProductDescription(ItemId itemId) {
		return productCatalog.getProductDescription(itemId);
	}

	// remove that
	public Money getTotal() {
		return currentSale.getTotal();
	}

	// remove that
	public String printReceipt() {
		return currentSale.printReceipt();
	}	
}
