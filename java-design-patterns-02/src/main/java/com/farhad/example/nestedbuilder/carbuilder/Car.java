package com.farhad.example.nestedbuilder.carbuilder;

import java.util.List;

import lombok.Data;

@Data
public class Car {
	private Engine engine;
	private List<Wheel> Wheels;
}
