package com.farhad.example.resume_generator.step4;

import java.time.LocalDateTime;
import java.util.Map;

public class LongResumeDataAgregator implements DataAggregator {

	@Override
	public Map<String, Object> aggregate(Map<String, Object> data) {
		if (!isValidLongResume(data)){
			throw new IllegalArgumentException("Not a valid data for long resume");
		}
		data.put("validUntil", LocalDateTime.now().plusDays(7));
		return data;
	}
	
	private boolean isValidLongResume(Map<String, Object> data) {
		return 
			data != null && 
			!data.isEmpty() && 
			data.containsKey("personName") &&
			data.containsKey("description");
	}

}
