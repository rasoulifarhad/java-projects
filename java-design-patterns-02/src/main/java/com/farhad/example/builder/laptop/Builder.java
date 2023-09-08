package com.farhad.example.builder.laptop;

// The Builder interface declares product construction steps that are common to all types of builders.
public interface Builder {
	void reset();
	void addRam(int size);
	void addSsd(int size);
	void addLed(LEDType type);
}
