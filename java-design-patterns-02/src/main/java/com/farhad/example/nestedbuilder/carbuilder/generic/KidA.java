package com.farhad.example.nestedbuilder.carbuilder.generic;

import lombok.Data;

@Data
public class KidA {
	
	private String note;

	private KidA() {

	}

	private KidA(Builder builder) {
		this.note = builder.note;		
	}
	public static Builder newBuilder() {
		return new Builder();
	}

	public static final class Builder extends NestedBuilder<Parent.Builder, KidA> {

		private String note;

		private Builder() {

		}
		public Builder withNote(String note) {
			this.note = note;
			return this;
		}

		@Override
		public KidA build() {
			return new KidA(this);
		}

	}
}
