package com.farhad.example.design_principles02.aggregation;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Organization {

	private String officeName;
	private List<Department> departments;
}
