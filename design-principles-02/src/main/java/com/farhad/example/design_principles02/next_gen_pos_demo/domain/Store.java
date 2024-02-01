package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

import java.util.ArrayList;
import java.util.List;

import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.Address;
import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.CustomerId;

import lombok.Data;

@Data
public class Store {

	private Address address;
	private String name;
	private ProductCatalog productCatalog;
	private Register register;
	private List<Sale> completedSales = new ArrayList<>();

	
	
	public Store(Address address, String name, ProductCatalog productCatalog) {
		this.address = address;
		this.name = name;
		this.productCatalog = productCatalog;
		this.register = new Register(this, productCatalog);
	}

	// public Store(Address address, String name) {
	// 	this.address = address;
	// 	this.name = name;
	// }


	public void addCompleteSale(Sale sale) {

		completedSales.add(sale);
	}

	public Customer getCustomer(CustomerId customerId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getCustomer'");
	}

}
