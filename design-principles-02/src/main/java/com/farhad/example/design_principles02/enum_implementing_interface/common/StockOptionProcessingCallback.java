package com.farhad.example.design_principles02.enum_implementing_interface.common;

public interface StockOptionProcessingCallback {

	
	// Processes stock options for the specified employee.Returns true if the
	// options were processed,false otherwise.
	void process(StockOptionEligible employee);
}
