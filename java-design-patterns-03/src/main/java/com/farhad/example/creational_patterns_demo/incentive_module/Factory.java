package com.farhad.example.creational_patterns_demo.incentive_module;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Factory {

	private final EmployeeId id;

	// - Check for KPI type and initialize the corresponding family of KPI classes.
	// - Check for employee department to initialize the family of KPI classes.
	// - Check for employee experience to initialize the properties of a particular KPI class.
	// - Check for different third-party service and different database connections required to initialize a particular KPI with specified 
	//   properties.
	// - The returned KPI class will be fully configured and ready to be consumed by the Incentive class. So, every complication related to 
	//   creating the KPI class is handled in this factory method.
	abstract public KPI createKPIOfType(String type);
}
