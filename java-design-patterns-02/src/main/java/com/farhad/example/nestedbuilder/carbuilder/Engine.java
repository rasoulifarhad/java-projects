package com.farhad.example.nestedbuilder.carbuilder;

import lombok.Data;

@Data
public class Engine {
	private int power;
	private int type;

	private Engine() {

	}

	private Engine(Builder builder) {
		setPower(builder.power);
		setType(builder.type);
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	public static Builder newBuilder(Engine copy) {
		Builder builder = new Builder();
		builder.power = copy.power;
		builder.type = copy.type;
		return builder;
	}

	public static final class Builder {

		private int power;
		private int type;

		private Builder() {

		}

		public Builder withPower(int power) {
			this.power = power;
			return this;
		}

		public Builder withType(int type) {
			this.type = type;
			return this;
		}

		public Engine build() {
			return new Engine(this);
		}
	}
}