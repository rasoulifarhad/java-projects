package com.farhad.example.design_principles02.elegant_objects_book.method_names.builders;

import java.io.InputStream;

public interface OutputPipe {

	void write(InputStream content);

	int bytes();

	long time();
}
