package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.lsp.good;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SettingsHelper {

	Map<ReadableSettings, Map<String, String>> getAllSettings(List<ReadableSettings> items) {
		Map<ReadableSettings, Map<String, String>> allSettings = new HashMap<>();
		for (ReadableSettings settings : items) {
			allSettings.put(settings, new HashMap<>(settings.getSettings()));
		}
		return allSettings;
	}

	List<String> setAllSettings(List<WritableSettings> items, List<Map<String, String>> values) {
		List<String> messages = new ArrayList<>();
		for (int i = 0; i < items.size(); i++) {
			if (!(items.get(i) instanceof GuestSettings)) {
				messages.add(items.get(i).setSettings(values.get(i)));
			}
		}
		return messages;
	}
}
