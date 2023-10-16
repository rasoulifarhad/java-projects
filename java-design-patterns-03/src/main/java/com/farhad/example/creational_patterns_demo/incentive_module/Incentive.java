package com.farhad.example.creational_patterns_demo.incentive_module;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class Incentive {
	// Connect to the database
	// Retrieve the minimal required information of this employee and their KPI from the database.
	// Depending on certain conditions, we may need additional information from the database.
	// The incentive calculation algorithm varies based on department and experience.
	// We might need to connect to different databases to obtain specific data.
	// We might need to connect to third-party services to acquire certain data.
	// Process all the parameters 
	// Provide the current year's incentive to the client	

	// 1. When a client calls `Incentive` with an `employee_id`, `Incentive` fetches the list of applicable KPIs for that employee.
    // 2. It then makes a call to each KPI class. While calling a specific KPI class, it checks the employee’s department and, based on that, creates an object of the appropriate `KPI+Dep` class and calls its method to calculate the incentive for that KPI.
    // 3. The calculated value is then passed back to the `Incentive` class. `Incentive` class will sum up incentive amount from each KPI and give that to Client.

	public List<String> getKPIListOfEmployee() {
		return Collections.emptyList();
	}

	public Amount getIncentiveOfEmployee(){
		List<String> kpis = getKPIListOfEmployee();
		return kpis.stream()
					.map(this::findIncentiveOfKpi)
					.map(Amount::getValue)
					.reduce(BigDecimal::add)
					.map(value -> new Amount(value))
					.orElse(new Amount(BigDecimal.ZERO));
	}

	Amount findIncentiveOfKpi(String type) {
		KPI kpi = factory.createKPIOfType(type);
		return kpi.getKPIIncentiveOf();
	}
		

	private Factory factory;
	private EmployeeId employeeId;
	
}
