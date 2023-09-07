package com.farhad.example.builder.laptop;

public interface Builder {
	void reset();
	void addRam(int size);
	void addSsd(int size);
	void addLed(LEDType type);
}
