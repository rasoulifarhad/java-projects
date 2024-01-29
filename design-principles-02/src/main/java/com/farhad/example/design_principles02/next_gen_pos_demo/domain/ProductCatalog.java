package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.ItemId;
import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.Money;

public class ProductCatalog {

	private Map<ItemId, ProductDescription> productMap = new HashMap<>();

	public ProductDescription getProductDescription(ItemId itemId) {
		return productMap.get(itemId);
	}
	
	public Set<ItemId> getIds() {
		return productMap.keySet();
	}

	public void loadProdSpecs() {
		
		ItemId id1 = ItemId.of(100);
		ItemId id2 = ItemId.of(200);
		ItemId id3 = ItemId.of(300);
		ItemId id4 = ItemId.of(400);
		ItemId id5 = ItemId.of(500);

		ProductDescription productDescription;

		productDescription = new ProductDescription("Product 1", Money.of(13.00), id1);
		productMap.put(id1, productDescription);

		productDescription = new ProductDescription("Product 2", Money.of(3.00), id2);
		productMap.put(id2, productDescription);

		productDescription = new ProductDescription("Product 3", Money.of(100.00), id3);
		productMap.put(id3, productDescription);

		productDescription = new ProductDescription("Product 4", Money.of(80.00), id4);
		productMap.put(id4, productDescription);

		productDescription = new ProductDescription("Product 5", Money.of(50.00), id5);
		productMap.put(id5, productDescription);
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
