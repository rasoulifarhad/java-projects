package com.farhad.example.refactoring.call_super.better;

public class AlphaTestCase extends TestCase {

	@Override
	final protected void setup() {
		alphaProjectSetup();
		doSetup();
	}

	protected void doSetup() {
	}

	private void alphaProjectSetup() {
	}

}
