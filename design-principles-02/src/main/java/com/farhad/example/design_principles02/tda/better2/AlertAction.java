package com.farhad.example.design_principles02.tda.better2;

public class AlertAction implements Action<CpuMonitor> {

	@Override
	public void action(CpuMonitor e) {
		System.out.println("Allert!!!!!");
		System.out.println("Value: " + e.getValue());
	}

}
