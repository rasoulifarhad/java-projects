package com.farhad.example.functional_interface.first_class_function;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Invoice {

	private final Customer customer;
	private String name;

	
}
