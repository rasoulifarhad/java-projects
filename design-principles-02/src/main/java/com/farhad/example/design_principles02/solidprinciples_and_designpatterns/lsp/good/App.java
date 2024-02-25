package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.lsp.good;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

	private final SettingsHelper settingsHelper;
	private List<WritableSettings> writableSettings = new ArrayList<>();
	private List<ReadableSettings> readableSettings = new ArrayList<>();

	public App(SettingsHelper settingsHelper) {
		this.settingsHelper = settingsHelper;

		GlobalSettings gs = new GlobalSettings();
		SectionSettings ss = new SectionSettings("Sport");
		UserSettings us = new UserSettings("User1");
		GuestSettings guestSettings = new GuestSettings();

		readableSettings.add(gs);
		readableSettings.add(ss);
		readableSettings.add(us);
		readableSettings.add(guestSettings);


		writableSettings.add(gs);
		writableSettings.add(ss);
		writableSettings.add(us);
	}

	public Map<ReadableSettings, Map<String, String>> getAllSettings() {
		return settingsHelper.getAllSettings(readableSettings);
	}

	public void save() {
		List<Map<String, String>> newSettings = new ArrayList<>();
		
		Map<String, String> global = new HashMap<>();
		global.put("Theme", "Winter");

		Map<String, String> section = new HashMap<>();
		section.put("Title", "Music");

		Map<String, String> user = new HashMap<>();
		user.put("DisplayName", "User2");

		Map<String, String> guest = new HashMap<>();
		guest.put("GuestName", "Another Guest");

		newSettings.add(global);
		newSettings.add(section);
		newSettings.add(user);
		newSettings.add(guest);

		List<String> messages = settingsHelper.setAllSettings(writableSettings, newSettings);

		System.out.println("Messages: ");
		messages.forEach(System.out::println);
	}

}
