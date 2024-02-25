package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.lsp.bad;

import java.util.HashMap;
import java.util.Map;

// Guest users, they can’t save any customization or preferences. They do get some default settings applied to various parts of the application.
public class GuestSettings implements Settings {

	private Map<String, String> maps;

	public GuestSettings() {
		maps = new HashMap<>();
		maps.put("GuestName", "boyy");
	}

	@Override
	public Map<String, String> getSettings() {
		return maps;
	}

	@Override
	public String setSettings(Map<String, String> settings) {
		throw new UnsupportedOperationException("Unimplemented method 'setSettings'");
	}

}
