package com.farhad.example.design_principles02.bowling_game_kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BowlingGameTest {

	private Game g;

	@BeforeEach
	protected void setup() {
		g = new Game();
	}

	private void rollMany(int n, int pins) {
		for (int i = 0; i < n; i++) {
			g.roll(pins);
		}
	}

	@Test
	public void testGutterGame() {
		rollMany(20, 0);
		assertEquals(0, g.score());
	}

	@Test
	public void testAllOnes() {
		rollMany(20, 1);
		assertEquals(20, g.score());

	}
}
