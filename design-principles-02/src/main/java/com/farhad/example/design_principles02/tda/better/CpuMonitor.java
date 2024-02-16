package com.farhad.example.design_principles02.tda.better;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CpuMonitor {

	private int value;
	private final int alertThreshold;

	public boolean exceedsThreshold() {
		return value >= alertThreshold;
	}
}
