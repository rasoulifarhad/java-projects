package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

import java.util.HashMap;
import java.util.Map;

import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.ItemId;

public class ProductCatalog {

	private Map<ItemId, ProductDescription> productMap = new HashMap<>();

	public ProductDescription getProductDescription(ItemId itemId) {
		return productMap.get(itemId);
	}
	

	public void loadProdSpecs() {
		
	}
}
