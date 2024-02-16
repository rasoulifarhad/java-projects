package com.farhad.example.design_principles02.tda.better2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CpuMonitor {

	private int value;
	private final int alertThreshold;
	private final Action<CpuMonitor> alertAction;

	public boolean exceedsThreshold() {
		return value >= alertThreshold;
	}

	public void sample() {
		if (exceedsThreshold()) {
			alertAction.action(this);
		}
	}

}
