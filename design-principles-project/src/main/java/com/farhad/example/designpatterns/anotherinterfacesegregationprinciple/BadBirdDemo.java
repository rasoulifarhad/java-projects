package com.farhad.example.designpatterns.anotherinterfacesegregationprinciple;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

// See https://github.com/mikeknep/SOLID/tree/main/interface_segregation
public class BadBirdDemo {
	
	interface Bird {
		void fly();
		void molt();
	}

	@Builder
	@Getter
	@ToString
	@EqualsAndHashCode
	static class Eagle implements Bird {

		private String currentLocation;
		private int numberOfFeathers;

		
		@Override
		public void fly() {
			this.currentLocation = "In the air";
			System.out.println("Flying...");
		}

		@Override
		public void molt() {
			numberOfFeathers -= 1;
			System.out.println("Molting...");
		}
		
	}

	@Builder
	@Getter
	@ToString
	@EqualsAndHashCode
	static class Penguin implements Bird {

		
		private String currentLocation;
		private int numberOfFeathers;

		@Override
		public void fly() {
			throw new UnsupportedOperationException("Penguin can not 'fly'");
		}

		@Override
		public void molt() {
			numberOfFeathers -= 1;
			System.out.println("Molting...");
		}

		public void swim() {
			this.currentLocation = "In the water";
		}

	}
}
