package com.farhad.example.designpatterns.anotherinterfacesegregationprinciple;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

public class GoodBirdDemo {
	

	interface FlyingCreature {
		void fly();
	}

	interface FeatheredCreature {
		void molt();
	}

	interface SwimmingCreature {
		void swim();
	}

	@Builder
	@Getter
	@ToString
	@EqualsAndHashCode
	static class Eagle implements FlyingCreature, FeatheredCreature {

		String currentLocation;
		int numberOfFeathers;

		@Override
		public void molt() {
			this.numberOfFeathers -= 1;
		}

		@Override
		public void fly() {
			this.currentLocation = "In the air";
		}

	}

	@Builder
	@Getter
	@ToString
	@EqualsAndHashCode
	static class Penguin implements FeatheredCreature, SwimmingCreature {

		String currentLocation;
		int numberOfFeathers;

		@Override
		public void swim() {
			this.currentLocation = "In the water";
		}

		@Override
		public void molt() {
			this.numberOfFeathers -= 1;
		}
	}
}
