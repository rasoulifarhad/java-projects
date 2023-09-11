package com.farhad.example.resume_generator.step4;

import java.util.Map;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TemplateProcess {
	
	private final TemplateRender templateRenderer;
	private final BasicResumeDataAggregator basicResumeDataAggregator;
	private final LongResumeDataAggregator longResumeDataAgregator;

	public String processTemplate(String templateName, Map<String, Object> data) {
		if (templateName.equals("basicResume")) {
			data = basicResumeDataAggregator.aggregate(data);
			return templateRenderer.render(templateName, data);

		} else if (templateName.equals("longResume")) {
			data = longResumeDataAgregator.aggregate(data);
			return templateRenderer.render(templateName, data); 
		} else {
			throw new IllegalArgumentException("template not suported: " + templateName);
		}
	}


}
