package com.farhad.example.design_principles02.rock_and_roll.ninth.instrument;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import lombok.Getter;

@Getter
public class InstrumentSpec {

	@Getter
	private Map<String, Object> properties;

	public InstrumentSpec() {
		properties = new HashMap<>();
	}

	public InstrumentSpec(Map<String, Object> properties) {
		this.properties = properties;
	}

	public Object getProperty(String propertyName) {
		return properties.getOrDefault(propertyName, null);
	}

	public boolean matches(InstrumentSpec example) {
		Set<Entry<String, Object>> exampleEntries = example.getProperties().entrySet();

		for (Entry<String, Object> entry : exampleEntries) {
			if (!entry.getValue().equals(properties.get(entry.getKey()))) {
				return false;
			}
		}
		return true;
	}
}
