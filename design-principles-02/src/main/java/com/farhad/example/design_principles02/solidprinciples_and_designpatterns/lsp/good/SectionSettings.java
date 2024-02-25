package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.lsp.good;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class SectionSettings implements ReadableSettings, WritableSettings {

	private Map<String, String> maps;

	public SectionSettings(String title) {
		maps = new HashMap<>();
		maps.put("Title", title);
	}

	@Override
	public Map<String, String> getSettings() {
		return maps;
	}

	@Override
	public String setSettings(Map<String, String> settings) {
		this.maps = settings;
		return "Section settings saved on " + LocalDateTime.now();
	}


}
