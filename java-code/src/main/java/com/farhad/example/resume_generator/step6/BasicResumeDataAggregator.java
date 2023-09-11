package com.farhad.example.resume_generator.step6;

import java.time.LocalDateTime;
import java.util.Map;

public class BasicResumeDataAggregator implements DataAggregator {

	@Override
	public Map<String, Object> aggregate(Map<String, Object> data) {
		if (!isValidResume(data)){
			throw new IllegalArgumentException("Not a valid data for basic resume");
		}
		data.put("validUntil", LocalDateTime.now());
		return data;
	}

	private boolean isValidResume(Map<String, Object> data) {
		return 
			data != null && 
			!data.isEmpty() && 
			data.containsKey("personName");
	}

	
}
