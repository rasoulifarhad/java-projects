package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.lsp.good;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class UserSettings implements ReadableSettings, WritableSettings {

	private Map<String, String> maps;

	public UserSettings(String userName) {
		maps = new HashMap<>();
		maps.put("DisplayName", userName);
	}

	@Override
	public Map<String, String> getSettings() {
		return maps;
	}

	@Override
	public String setSettings(Map<String, String> settings) {
		this.maps = settings;
		return "User settings saved on " + LocalDateTime.now();
	}

}
