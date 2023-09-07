package com.farhad.example.discounter.adapters.discounter.testcases;

import java.io.File;
import java.time.Instant;

import org.testng.TestNG;

import com.farhad.example.discounter.adapters.Driver;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestRunner implements Driver {

	private static final String OUTPUT_DIRECTORY = 
		System.getProperty("user.home") + File.separator +
		"discounterApp" + File.separator +
		"test-output" + File.separator + 
		Instant.now().toEpochMilli();

	private final String rateRepositoryType;


	@Override
	public void run(String... args) {
		System.out.println("==========================================================");
		System.out.println("Running test cases driver using testNG framework");
		System.out.println("Html report will be generated to the following directory:");
		System.out.println(OUTPUT_DIRECTORY);
		System.out.println("===========================================================");
		TestNG testNG = new TestNG();
		testNG.setOutputDirectory(OUTPUT_DIRECTORY);
		testNG.setTestClasses(testClassesToRun());
		testNG.run();
	}


	private Class[] testClassesToRun() {
		if (rateRepositoryType == null) {
			return new Class[] {NoRateRepositoryTests.class};
		} 
		if (rateRepositoryType.trim().isEmpty()) {
			return new Class[] {NoRateRepositoryTests.class};
		}
		if (rateRepositoryType.trim().equals("none")) {
			return new Class[] {NoRateRepositoryTests.class};
		}
		if (rateRepositoryType.trim().equals("stub")) {
			return new Class[] {};
		}
		if (rateRepositoryType.trim().equals("file")) {
			return new Class[] {FileRateRepositoryTests.class};
		}
		return new Class[] {};
	}
	
}
