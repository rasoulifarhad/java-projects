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

	@Test
	public void testGutterGame2() {
		for (int i = 0; i < 20; i++) {
			g.roll(0);
		}
		assertEquals(0, g.score());
	}

	@Test
	public void testAllOnes() {
		for (int i = 0; i < 20; i++) {
			g.roll(1);
		}
		assertEquals(20, g.score());

	}
}
