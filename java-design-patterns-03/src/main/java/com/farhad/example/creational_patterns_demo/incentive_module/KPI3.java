package com.farhad.example.creational_patterns_demo.incentive_module;

import java.util.Collections;
import java.util.List;

public class KPI3  implements KPI {
	private void connectTopDB(){

	}

	private List<String> findDepartmentOf(EmployeeId id) {
		return Collections.emptyList();
	}
	public Amount getKPI3IncentiveOf(EmployeeId id){
		return null;
	}

	@Override
	public Amount getKPIIncentiveOf(EmployeeId id) {
		return getKPI3IncentiveOf(id);
	}

}
