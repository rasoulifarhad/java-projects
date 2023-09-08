package com.farhad.example.builder.laptop;

import lombok.RequiredArgsConstructor;

// The Director class defines the order in which to call construction steps.
@RequiredArgsConstructor
public class Director {
	
	private static final int RAM_16_GB = 16;
	private static final int SSD_1_GB = 1;

	private final Builder builder;

	public void makeGamingLaptop() {
		builder.addRam(RAM_16_GB);
		builder.addSsd(SSD_1_GB);
		builder.addLed(LEDType.TOUCH);
	}

	public void makeHomeLaptop() {
		builder.addRam(RAM_16_GB / 8);
		builder.addSsd(SSD_1_GB);
		builder.addLed(LEDType.STANDARD);
	}

	public void makeBusinessLaptop() {
		builder.addRam(RAM_16_GB / 4);
		builder.addSsd(SSD_1_GB);
		builder.addLed(LEDType.STANDARD);
	}
}
