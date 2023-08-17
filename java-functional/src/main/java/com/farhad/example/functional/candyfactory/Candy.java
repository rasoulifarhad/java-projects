package com.farhad.example.functional.candyfactory;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
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
}
