package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.lsp.bad;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class GlobalSettings implements Settings {

	private Map<String, String> maps;

	
	public GlobalSettings() {
		maps = new HashMap<>();
		maps.put("Theme", "Summer");
	}

	@Override
	public Map<String, String> getSettings() {
		return maps;
	}

	@Override
	public String setSettings(Map<String, String> settings) {
		this.maps = settings;
		return "Global settings saved on " + LocalDateTime.now();
	}

}
