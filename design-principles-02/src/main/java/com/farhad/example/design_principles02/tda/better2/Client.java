package com.farhad.example.design_principles02.tda.better2;

import java.util.List;

public class Client {

	public void alertService(List<CpuMonitor> cpuMonitors) {
		for (CpuMonitor cpuMonitor : cpuMonitors) {
			cpuMonitor.sample();
		}
	}
}
