package com.farhad.example.refactoring.call_super.better;

public class BetterAlphaTestCase extends TestCase {

	@Override
	public void runBare() {
		alphaProjectSetup();
		setup();

		try {
			runTest();
		} finally {
			tearDown();
		}
	}

	private void alphaProjectSetup() {
	}
	
}
