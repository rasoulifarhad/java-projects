package com.farhad.example.factory.builder;

import lombok.ToString;

@ToString
public class Burger {

	private Size size;
	private boolean cheese = false;
	private boolean pepperoni = false;
	private boolean lettuce = false;
	private boolean tomato = false;

	public Burger(BurgerBuilder builder) {
		this.size = builder.size;
		this.cheese = builder.cheese;
		this.pepperoni = builder.pepperoni;
		this.lettuce = builder.lettuce;
		this.tomato = builder.tomato;
	}

	public static BurgerBuilder of(Size size) {
		return BurgerBuilder.of(size);
	}
	static class BurgerBuilder {

		private Size size;
		private boolean cheese = false;
		private boolean pepperoni = false;
		private boolean lettuce = false;
		private boolean tomato = false;

		private BurgerBuilder(Size size) {
			this.size = size;
		}

		public static BurgerBuilder of(Size size) {
			return new BurgerBuilder(size);
		}
		
		public BurgerBuilder withCheese() {
			this.cheese = true;
			return this;
		}

		public BurgerBuilder withPepperoni() {
			this.pepperoni = true;
			return this;
		}

		public BurgerBuilder withLettuce() {
			this.lettuce = true;
			return this;
		}

		public BurgerBuilder withTomato() {
			this.tomato = true;
			return this;
		}

		public Burger build() {
			return new Burger(this);
		}
	}
	
}
