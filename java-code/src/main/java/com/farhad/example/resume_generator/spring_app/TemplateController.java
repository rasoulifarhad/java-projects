package com.farhad.example.resume_generator.step6.spring_app;

// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import com.farhad.example.resume_generator.step6.TemplateProcess;

import lombok.RequiredArgsConstructor;

// @RestController
@RequiredArgsConstructor
public class TemplateController {
	private final TemplateProcess templateProcess;

	// @PutMapping("/templates/{templateName}")
	public String renderResume(
			/*@PathVariable*/ String templateName,
			/*@RequestBody*/ Map<String, Object> data) {
	  return templateProcess
			  .processTemplate(templateName, data);
	}	
}
