package com.farhad.example.resume_generator.step3;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TemplateProcess {
	
	private final TemplateRenderer templateRenderer;

	public String processTemplate(String templateName, Map<String, Object> data) {
		if (templateName.equals("basicResumeTrmplate.template")) {

			if (!isValidLongResume(data)){
				throw new IllegalArgumentException("Not a valid data for long resume");
			}
			data.put("validUntil", LocalDateTime.now().plusDays(7));
			return templateRenderer.render(templateName, data);

		} else if (templateName.equals("longResumeTrmplate.template")) {

			if (!isValidBasicResume(data)){
				throw new IllegalArgumentException("Not a valid data for basic resume");
			}
			data.put("validUntil", LocalDateTime.now());
			return templateRenderer.render(templateName, data); 
		} else {
			throw new IllegalArgumentException("template not suported: " + templateName);
		}
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
