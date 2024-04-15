package com.farhad.example.design_principles02.elegant_objects_book.method_names.public_constants.good;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Rows {


	void print(PrintStream printStream) {
		for (Row row : fetch()) {
			printStream.print(new CRLFString(
				String.format("{ %s }", row)
			));
		}
	}

	private List<Row> fetch() {
		return new ArrayList<>();
	}
}
