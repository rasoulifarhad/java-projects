package com.farhad.example.design_principles02.elegant_objects_book.method_names.public_constants;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Rows {

	private static final String CRLF = "\r\n";

	void print(PrintStream printStream) {
		for (Row row : fetch()) {
			printStream.printf("{ %s }%s", row, CRLF);
		}
	}

	private List<Row> fetch() {
		return new ArrayList<>();
	}
}
