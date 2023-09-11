package com.farhad.example.resume_generator.step2;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ResumeTemplateProcess {
	
	private final TemplateRenderer templateRenderer;

	public String processBasicResumeTemplate(Map<String, Object> data) {
		if (!isValidBasicResume(data)){
			throw new IllegalArgumentException("Not a valid data for basic resume");
		}
		data.put("validUntil", LocalDateTime.now());
		return templateRenderer.render("basicResumeTrmplate.template", data);
	}

	public String processLongResumeTemplate(Map<String, Object> data) {
		if (!isValidLongResume(data)){
			throw new IllegalArgumentException("Not a valid data for long resume");
		}
		data.put("validUntil", LocalDateTime.now().plusDays(7));
		return templateRenderer.render("longResumeTrmplate.template", data);
	}

	private boolean isValidLongResume(Map<String, Object> data) {
		return 
			data != null && 
			!data.isEmpty() && 
			data.containsKey("personName") &&
			data.containsKey("description");
	}

	private boolean isValidBasicResume(Map<String, Object> data) {
		return 
			data != null && 
			!data.isEmpty() && 
			data.containsKey("personName");
	}
}
