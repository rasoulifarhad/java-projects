package com.farhad.example.design_principles02.aggregation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Employee {

	private String name;
	private int id;
	private String dept;
}
