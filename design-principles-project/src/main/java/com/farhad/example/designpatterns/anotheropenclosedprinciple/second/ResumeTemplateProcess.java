package com.farhad.example.designpatterns.anotheropenclosedprinciple.second;

import java.time.LocalDateTime;
import java.util.Map;

import com.farhad.example.designpatterns.anotheropenclosedprinciple.TemplateRender;

import lombok.RequiredArgsConstructor;

// Seems like a kind of resume could be an extension point of our module.
@RequiredArgsConstructor
public class ResumeTemplateProcess {
	private final TemplateRender templateRender;

	public String processBasicResumeTemplate(Map<String, Object> data) {
		if (!isValidBasicResume(data)) {
			throw new IllegalArgumentException("Not valid data for basic");
		}
		data.put("validUntil", LocalDateTime.now());
		return templateRender.render("basicResumeTemplate.template", data);
	}

	public String processLongResumeTemplate(Map<String, Object> data) {
		if (!isValidLongResumeTemplate(data)) {
			throw new IllegalArgumentException("Not valid data for long resume");
		}

		data.put("validUntil", LocalDateTime.now().plusDays(7));
		return templateRender.render("longResumeTemplate.template", data);
	}

	private boolean isValidLongResumeTemplate(Map<String, Object> data) {
		return data != null && 
			   !data.isEmpty() &&
			   data.containsKey("personName") &&
			   data.containsKey("description");	
	}

	private boolean isValidBasicResume(Map<String, Object> data) {
		return data != null && 
			   !data.isEmpty() && 
			   data.containsKey("personName");
	}

	
}
