package com.farhad.example.designpatterns.anotheropenclosedprinciple.first;

import java.time.LocalDateTime;
import java.util.Map;

import com.farhad.example.designpatterns.anotheropenclosedprinciple.TemplateRender;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ResumeTemplateProcess {
	private final TemplateRender templateRender;

	public String processResumeTemplate(Map<String, Object> data) {
		if (!isValid(data)) {
			throw new IllegalArgumentException("Not valid data");
		}
		data.put("validUntil", LocalDateTime.now());
		return templateRender.render("resumeTemplate.template", data);
	}

	private boolean isValid(Map<String, Object> data) {
		return data != null && !data.isEmpty() && data.containsKey("personName");
	}

	
}
