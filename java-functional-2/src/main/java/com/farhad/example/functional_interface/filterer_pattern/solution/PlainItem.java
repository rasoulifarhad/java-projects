package com.farhad.example.functional_interface.filterer_pattern.solution;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Getter
@Accessors(fluent = true)
public class PlainItem implements Item {

	private final String name;


}
