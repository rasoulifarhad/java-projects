package com.farhad.example.refactoring.call_super.better;

public abstract class TestCase {
	public void runBare() {
		setup();

		try {
			runTest();
		} finally {
			tearDown();
		}
	}

	protected void tearDown() {
	}

	protected void setup() {
	}

	protected void runTest() {
	}

}
