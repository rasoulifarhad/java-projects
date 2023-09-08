package com.farhad.example.nestedbuilder.carbuilder.generic;

import lombok.Data;

@Data
public class KidB {
	
	private String note;

	private KidB() {

	}
	private KidB(Builder builder) {
		this.note = builder.note;
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	public static final class Builder extends NestedBuilder<Parent.Builder, KidB> {

		private String note;

		private Builder() {

		}

		public Builder withNote(String note) {
			this.note =note;
			return this;
		}

		@Override
		public KidB build() {
			return new KidB(this);
		}

	}
}
