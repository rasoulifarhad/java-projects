package com.farhad.example.designpatterns.interfacesegregationprinciple;

import org.junit.jupiter.api.Test;

import com.farhad.example.designpatterns.interfacesegregationprinciple.InterfaceSegregationPrincipleDemo.Better.ToyBuilder;
import com.farhad.example.designpatterns.interfacesegregationprinciple.InterfaceSegregationPrincipleDemo.Better.ToyCar;
import com.farhad.example.designpatterns.interfacesegregationprinciple.InterfaceSegregationPrincipleDemo.Better.ToyHouse;
import com.farhad.example.designpatterns.interfacesegregationprinciple.InterfaceSegregationPrincipleDemo.Better.ToyPlane;

public class InterfaceSegregationPrincipleDemorTest {
	
	@Test
	void testBuildToyCar() {
		ToyCar toy = ToyBuilder.buildToyCar();
		System.out.println(toy);
	}

	@Test
	void testBuildToyHouse() {
		ToyHouse toy = ToyBuilder.buildToyHouse();
		System.out.println(toy);
	}

	@Test
	void testBuildToyPlane() {
		ToyPlane toy = ToyBuilder.buildToyPlane();
		System.out.println(toy);
	}
}
