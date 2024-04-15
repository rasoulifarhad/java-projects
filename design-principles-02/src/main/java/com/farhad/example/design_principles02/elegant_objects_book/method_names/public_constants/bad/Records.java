package com.farhad.example.design_principles02.elegant_objects_book.method_names.public_constants.bad;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Records {

	private static final String CRLF = "\r\n";

	private List<Record> all = new ArrayList<>(); 
	void write(Writer out) throws IOException {
		for (Record record : all) {
			out.write(record.toString());
			out.write(CRLF);
		}
	}
}
