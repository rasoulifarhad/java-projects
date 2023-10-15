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
	Amount getIncentiveOf(EmployId id){
		return  getKPIListOf(id).stream()
						.map(kpi -> kpi.getIncentiveOf(id))
						.map(Amount::getValue)
						.reduce(BigDecimal::add)
						.map(value -> new Amount(value))
						.orElse(new Amount(BigDecimal.ZERO));
	}

	private List<KPI>  getKPIListOf(EmployId employId) {
		return Collections.emptyList();
	}
	
}
