package com.farhad.example.resume_generator.step4;

import java.util.Map;

public interface DataAggregator {
	Map<String, Object> aggregate(Map<String, Object> data);
}
