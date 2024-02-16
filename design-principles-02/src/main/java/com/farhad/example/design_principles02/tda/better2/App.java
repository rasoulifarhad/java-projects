package com.farhad.example.design_principles02.tda.better2;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {

		List<CpuMonitor> cpuMonitors = new ArrayList<>();

		AlertAction alertAction = new AlertAction();
		CpuMonitor cpuMonitor = new CpuMonitor(90, alertAction);
		cpuMonitor.setValue(30);
		cpuMonitors.add(cpuMonitor);

		cpuMonitor = new CpuMonitor(90, alertAction);
		cpuMonitor.setValue(98);
		cpuMonitors.add(cpuMonitor);

		cpuMonitor = new CpuMonitor(90, alertAction);
		cpuMonitor.setValue(45);
		cpuMonitors.add(cpuMonitor);

		Client client = new Client();

		client.alertService(cpuMonitors);
	}
}
