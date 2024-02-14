package com.farhad.example.design_principles02.domain_oriented_observability.sixth;

import java.util.Map;

public interface Metrics {

	void increment(String string, Map<String, Object> singletonMap);

	void gauge(String string, Object totalPrice);

}
