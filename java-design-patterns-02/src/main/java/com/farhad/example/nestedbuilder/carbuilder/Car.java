package com.farhad.example.nestedbuilder.carbuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

	public static WheelListBuilder newWheelListBuilder() {
		return new WheelListBuilder();
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

	public static final class WheelListBuilder {
		private List<Wheel> wheels;

		private WheelListBuilder() {

		}

		public WheelListBuilder withNewList() {
			wheels = new ArrayList<>();
			return this;
		}

		public WheelListBuilder withList(List<Wheel> wheels) {
			this.wheels = wheels;
			return this;
		}

		public WheelListBuilder addWheel(Wheel wheel) {
			Objects.requireNonNull(wheels);
			// this.wheels = this.wheels == null ? withNewList().wheels : this.wheels;
			this.wheels.add(wheel);
			return this;
		}

		public List<Wheel> build() {
			if (this.wheels.size() != 4 ){
				throw new IllegalStateException("Wheel number must be 4: " + wheels.size());
			}
			return wheels; 
		}
	}
}
