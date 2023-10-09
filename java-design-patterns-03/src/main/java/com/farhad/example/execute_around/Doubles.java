package com.farhad.example.execute_around;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public final class Doubles {
	
	private Doubles() {
		throw new AssertionError("can not be instantiated");
	}

	public static double read(ScannerDoubleFunction sdf) throws IOException {
		if (sdf == null) {
			throw new IllegalArgumentException("Lambda cannot be null");
		}
		try (Scanner scanner = new Scanner(Paths.get("doubles.txt"), "UTF-8")) {
			return sdf.readDouble(scanner);
		} 
	}

}
