package com.farhad.example.resume_generator.step4;

import java.util.Map;

public interface TemplateRender {
		String render(String name, Map<String, Object> data);

}
