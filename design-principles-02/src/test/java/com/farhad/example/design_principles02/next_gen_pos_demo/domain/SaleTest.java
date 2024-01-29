package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.ItemId;
import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.Money;

public class SaleTest {

	@Test
	public void makeLineItemTest() {
		// given
		Sale sale = new Sale();
		Money total = Money.of(7.5);
		Money price = Money.of(2.5);
		ItemId id = ItemId.of(1);
		ProductDescription productDescription = new ProductDescription("Product 1", price, id);

		// when
		sale.makeLineItem(productDescription, 1);
		sale.makeLineItem(productDescription, 2);
		
		// then
		System.out.println(sale.getTotal());
		assertTrue(sale.getTotal().equals(total));
	}
}
