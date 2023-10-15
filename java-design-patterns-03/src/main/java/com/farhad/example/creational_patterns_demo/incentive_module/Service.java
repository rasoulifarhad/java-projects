package com.farhad.example.creational_patterns_demo.incentive_module;

public interface Service {
	// determines the respective incentive for the employee as of the current date
	Amount getIncentiveOf(EmployId id);
	Amount getKYCOf(EmployId id);
}
