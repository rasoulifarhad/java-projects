package com.farhad.example.resume_generator.step1;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ResumeTemplateProcess {
	
	private final TemplateRenderer templateRenderer;

	public String processResumeTemplate(Map<String, Object> data) {
		if (!isValid(data)){
			throw new IllegalArgumentException("Not a valid data for resume");
		}
		data.put("validUntil", LocalDateTime.now());
		return templateRenderer.render("resumeTrmplate.template", data);
	}

	private boolean isValid(Map<String, Object> data) {
		return data != null && data.containsKey("personName");
	}
}
