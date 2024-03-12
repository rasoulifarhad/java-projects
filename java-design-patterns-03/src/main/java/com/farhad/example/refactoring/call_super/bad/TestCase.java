package com.farhad.example.refactoring.call_super.bad;

public abstract class TestCase {

	public void runBare() {
		setup();

		try {
			runTest();
		} finally {
			tearDown();
		}
	}

	private void tearDown() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'tearDown'");
	}

	protected void setup() {
	}

	protected void runTest() {
	}

}
