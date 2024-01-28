package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.ItemId;

public class ProductCatalog {

	private Map<ItemId, ProductDescription> productMap = new HashMap<>();

	public ProductDescription getProductDescription(ItemId itemId) {
		return productMap.get(itemId);
	}
	
	public Set<ItemId> getIds() {
		return productMap.keySet();
	}

	public void loadProdSpecs() {

	}

	// private void loadProduct(String dir){
	// 	final File folder = new File(dir);
	// 	for (final File fileEntry : folder.listFiles()) {
	// 		Properties prop = new Properties();
	// 		try {
	// 			prop.load(new FileReader(fileEntry.getPath()));
	// 			ItemId id = new ItemId(prop.get("itemId").toString());
	// 			Money price = new Money(new BigDecimal(prop.getProperty("price")));
	// 			String description = prop.getProperty("description");
			
	// 			ProductDescription desc = new ProductDescription(id,price,description);
	// 			descriptions.put(id,desc);
	// 		} catch (IOException e) {
	// 			e.printStackTrace();
	// 		}
	// 	}
	// }	
}
