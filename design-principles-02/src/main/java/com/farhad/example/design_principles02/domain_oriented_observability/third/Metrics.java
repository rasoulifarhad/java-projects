package com.farhad.example.design_principles02.domain_oriented_observability.third;

import java.util.Map;

public interface Metrics {

	void increment(String string, Map<String, Object> singletonMap);

}
