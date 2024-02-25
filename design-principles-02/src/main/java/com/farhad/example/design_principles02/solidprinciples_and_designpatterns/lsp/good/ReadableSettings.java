package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.lsp.good;

import java.io.Serializable;
import java.util.Map;

public interface ReadableSettings extends Serializable{

	Map<String, String> getSettings();

}
