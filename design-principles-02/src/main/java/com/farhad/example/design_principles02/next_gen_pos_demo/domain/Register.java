package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.ItemId;
import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.Money;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Register {

	private final ProductCatalog productCatalog;
	private Sale currentSale;
	private final Store store;

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
		Payment payment = currentSale.makePayment(cashTendered);
		store.addCompleteSale(currentSale);

	}

	private ProductDescription getProductDescription(ItemId itemId) {
		return productCatalog.getProductDescription(itemId);
	}

}
