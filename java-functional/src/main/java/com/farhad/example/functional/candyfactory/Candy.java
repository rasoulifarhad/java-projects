package com.farhad.example.functional.candyfactory;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Candy {
	
	private Type type;
	private Color color;

	enum Color {
		RED, BLUE, GREEN, YELLOW;
	}

	enum Type {
		REGULAR, PEANUT, PRETZEL;
	}

	interface CandyMatcher {
		boolean matches(Candy candy);
	}

	@RequiredArgsConstructor
	static class ColorMatcher implements CandyMatcher {

		private final Color color;
		@Override
		public boolean matches(Candy candy) {
			return candy.getColor().equals(color);
		}
	}

	@RequiredArgsConstructor
	static class TypeMatcher implements CandyMatcher {

		private final Type type;
		@Override
		public boolean matches(Candy candy) {
			return candy.getType().equals(type);
		}

	}
}
