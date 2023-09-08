package com.farhad.example.builder.laptop;

// Concrete Builders (LaptopBuilder) provides a different implementation of the construction steps.
public class LaptopBuilder implements Builder {

	private Laptop laptop;
	private StringBuilder info;

	public LaptopBuilder() {
		reset();
	}

	@Override
	public void reset() {
		laptop = new Laptop();
		info = new StringBuilder("Laptop configuration:\n");
	}

	@Override
	public void addRam(int size) {
		info.append("Adding RAM: ").append(size).append("GB").append("\n");
	}

	@Override
	public void addSsd(int size) {
		info.append("Adding SSD: ").append(size).append("GB").append("\n");
	}

	@Override
	public void addLed(LEDType type) {
		info.append("Adding LED:").append(type).append("\n");
	}

	public Laptop build() {
		laptop.setInfo(info.toString());
		return laptop;
	}
	
}
