package com.farhad.example.refactoring.refactoringbook.performance;

import java.util.List;

import lombok.Data;

@Data
public class Invoice {

	private String customer;
	List<Performance> performances;
}
