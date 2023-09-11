package com.farhad.example.resume_generator.step1;

import java.util.Map;

// TemplateRender renders a template with a specific template’s name and a map of data.
public interface TemplateRender {
	String render(String name, Map<String, Object> data);
}
