package com.farhad.example.design_principles02.implicit_dependencies.explicit_dependencies;

import java.io.IOException;

public interface Logger {
	void log(String message) throws IOException;
}
