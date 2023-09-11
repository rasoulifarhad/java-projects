package com.farhad.example.resume_generator.step6;

import java.util.Map;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TemplateProcess {
	
	private final TemplateRender templateRenderer;
	private final Map<String, DataAggregator> dataAggregators;

	public String processTemplate(String templateName, Map<String, Object> data) {
		if (dataAggregators.containsKey(templateName)) {
			DataAggregator dataAggregator = dataAggregators.get(templateName);
			data = dataAggregator.aggregate(data);
			return templateRenderer.render(templateName + ".template", data);
		} else {
			throw new IllegalArgumentException("template not suported: " + templateName);
		}
	}
}
