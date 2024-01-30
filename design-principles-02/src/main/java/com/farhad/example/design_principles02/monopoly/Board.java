package com.farhad.example.design_principles02.monopoly;

import java.util.Map;

public class Board {


	private Map<String, Square> squares;

	public Square getSquare(Square location, String name) {
		return squares.get(name);
	}
}
