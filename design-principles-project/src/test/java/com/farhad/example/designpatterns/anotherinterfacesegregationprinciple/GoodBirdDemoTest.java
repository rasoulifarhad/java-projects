package com.farhad.example.designpatterns.anotherinterfacesegregationprinciple;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.farhad.example.designpatterns.anotherinterfacesegregationprinciple.GoodBirdDemo.Eagle;
import com.farhad.example.designpatterns.anotherinterfacesegregationprinciple.GoodBirdDemo.Penguin;

public class GoodBirdDemoTest {
	
	@Test
	public void testEagle() {
		Eagle eagle = Eagle.builder().numberOfFeathers(5).build();
		
		eagle.fly();
		assertEquals("In the air", eagle.getCurrentLocation());

		eagle.molt();
		assertEquals(4, eagle.getNumberOfFeathers());
	}

	@Test
	public void testPenguin() {
		Penguin penguin = Penguin.builder().numberOfFeathers(5).build();

		penguin.swim();
		assertEquals("In the water", penguin.getCurrentLocation());

		penguin.molt();
		assertEquals(4, penguin.getNumberOfFeathers());
	}
}
