package com.farhad.example.resume_generator.step2;

import java.util.Map;

public interface TemplateRenderer {
		String render(String name, Map<String, Object> data);

}
