package com.farhad.example.design_principles02.aggregation;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter	
public class Department {

	private String name;
	private List<Employee> employees;
}
