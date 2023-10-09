package com.farhad.example.design_principles02.solid_principles.save_to_database_ocp;

public interface InvoicePersistence {
	
	void save(Invoice invoice);
}
