package com.farhad.example.design_principles02.tda.bad;

import java.util.List;

public class Client {

	public void alertService(List<CpuMonitor> cpuMonitors) {
		for (CpuMonitor cpuMonitor : cpuMonitors) {
			if(cpuMonitor.getValue() > 90) {
				System.out.println("Alert!!!!");
			}
		}
	}
}
