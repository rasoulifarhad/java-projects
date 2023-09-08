package com.farhad.example.nestedbuilder.carbuilder;

import java.util.List;

import lombok.Data;

@Data
public class Car {
	private Engine engine;
	private List<Wheel> wheels;

	private Car() {

	}

	private Car(Builder builder) {
		setEngine(builder.engine);
		setWheels(builder.wheels);
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	public static Builder newBuilder(Car copy) {
		Builder builder = new Builder();
		builder.engine = copy.engine;
		builder.wheels = copy.wheels;
		return builder;
	}

	public static final class Builder {

		private Engine engine;
		private List<Wheel> wheels;

		private Builder() {

		}

		public Builder withEngine(Engine engine) {
			this.engine = engine;
			return this;
		}

		public Builder withWheels(List<Wheel> wheels) {
			this.wheels = wheels;
			return this;
		}

		public Car builde() {
			return new Car(this);
		}
	}
}
