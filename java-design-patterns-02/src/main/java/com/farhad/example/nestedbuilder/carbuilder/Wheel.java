package com.farhad.example.nestedbuilder.carbuilder;

import lombok.Data;

@Data
public class Wheel {
	private int size;
	private int type;
	private int color;

	private Wheel() {

	}

	private Wheel(Builder builder) {
		setSize(builder.size);
		setType(builder.type);
		setColor(builder.color);
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	public static Builder newBuilder(Wheel copy) {
		Builder builder = new Builder();
		builder.size = copy.size;
		builder.type = copy.type;
		builder.color = copy.color;
		return builder;
	}

	public static final class Builder {
		private int size;
		private int type;
		private int color;

		private Builder() {

		}

		public Builder withSize(int size) {
			this.size = size;
			return this;
		}

		public Builder withType(int type) {
			this.type = type;
			return this;
		}

		public Builder withColor(int color) {
			this.color = color;
			return this;
		}

		public Wheel build() {
			return new Wheel(this);
		}

	}
}
