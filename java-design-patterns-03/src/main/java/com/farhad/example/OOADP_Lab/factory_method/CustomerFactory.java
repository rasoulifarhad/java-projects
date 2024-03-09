package com.farhad.example.OOADP_Lab.factory_method;

public class CustomerFactory {

	Customer getCustomer(String type) {

		if(type.equalsIgnoreCase("first time")) {
			return new FTCustomer();
		} else if (type.equalsIgnoreCase("regular")) {
			return new RCustomer();
		} else if (type.equalsIgnoreCase("senior citizen")) {
			return new SCCustomer();
		} else {
			return null;
		}

	}
}
