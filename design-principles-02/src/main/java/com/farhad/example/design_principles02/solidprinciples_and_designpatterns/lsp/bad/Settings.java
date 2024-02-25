package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.lsp.bad;

import java.io.Serializable;
import java.util.Map;

public interface Settings extends Serializable{

	Map<String, String> getSettings();

	String setSettings(Map<String, String> settings);
}
