package com.farhad.example.resume_generator.step6.spring_app;

import java.util.Map;

import com.farhad.example.resume_generator.step6.TemplateRender;

public class BasicTemplateRender implements TemplateRender {

	@Override
	public String render(String name, Map<String, Object> data) {
		return "Template to be replaced: " + name + ", with data: " + data;
	}
	
}
