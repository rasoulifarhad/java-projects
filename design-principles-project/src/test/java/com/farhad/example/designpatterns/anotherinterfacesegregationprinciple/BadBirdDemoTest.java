package com.farhad.example.designpatterns.anotherinterfacesegregationprinciple;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.farhad.example.designpatterns.anotherinterfacesegregationprinciple.BadBirdDemo.Eagle;
import com.farhad.example.designpatterns.anotherinterfacesegregationprinciple.BadBirdDemo.Penguin;

public class BadBirdDemoTest {

	 @Test
	 public void eagleTest() {
		Eagle eagle = Eagle.builder().numberOfFeathers(5).build();
		eagle.fly();

		assertEquals("In the air", eagle.getCurrentLocation());

		eagle.molt();
		assertEquals(4, eagle.getNumberOfFeathers());
	 }

	 @Test
	 public void penguinTest() {

		Penguin penguin = Penguin.builder().numberOfFeathers(5).build();

		penguin.molt();
		assertEquals(4, penguin.getNumberOfFeathers());

		penguin.swim();
		assertEquals("In the water", penguin.getCurrentLocation());

		assertThrows(UnsupportedOperationException.class, () -> penguin.fly());
	 }
}
