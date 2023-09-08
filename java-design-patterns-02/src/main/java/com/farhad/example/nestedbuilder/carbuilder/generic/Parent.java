package com.farhad.example.nestedbuilder.carbuilder.generic;

import lombok.Data;

@Data
public class Parent {
	
	private KidA kidA;
	private KidB kidB;

	private Parent() {

	}
	private Parent(Builder builder) {
		this.kidA = builder.kidA;
		this.kidB = builder.kidB;
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	public static final class Builder {

		private KidA kidA;
		private KidB kidB;

		private Builder() {

		}

		public Builder withKidA(KidA kidA){
			this.kidA = kidA;
			return this;
		}

		public Builder withKidB(KidB kidB) {
			this.kidB = kidB;
			return this;
		}

		private KidA.Builder kidABuilder = KidA.newBuilder().withParentBuilder(this);
		private KidB.Builder kidBBuilder = KidB.newBuilder().withParentBuilder(this); 
		public KidA.Builder addKidA() {
			return this.kidABuilder;
		}

		public KidB.Builder addKidB() {
			return kidBBuilder;
		}

		public Parent build() {
			return new Parent(this);
		}
	}
}
