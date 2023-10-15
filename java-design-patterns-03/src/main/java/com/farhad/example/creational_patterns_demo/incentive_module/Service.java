package com.farhad.example.creational_patterns_demo.incentive_module;

public interface Service {
	// determines the respective incentive for the employee as of the current date
	// Connect to the database
	// Retrieve the minimal required information of this employee and their KPI from the database.
	// Depending on certain conditions, we may need additional information from the database.
	// The incentive calculation algorithm varies based on department and experience.
	// We might need to connect to different databases to obtain specific data.
	// We might need to connect to third-party services to acquire certain data.
	// Process all the parameters 
	// Provide the current year's incentive to the client	
	Amount getIncentiveOf(EmployeeId id);
	Amount getKYCOf(EmployeeId id);
}
