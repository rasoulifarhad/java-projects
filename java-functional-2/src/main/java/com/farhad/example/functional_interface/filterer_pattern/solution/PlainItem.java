package com.farhad.example.functional_interface.filterer_pattern.solution;

import com.farhad.example.functional_interface.filterer_pattern.Item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Getter
@Accessors(fluent = true)
@Value
final public class PlainItem implements Item {

	private final String name;


}
