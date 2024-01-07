package com.farhad.example.design_principles02.composite_design_pattern;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Node {

	long id;
	List<Node> nodes;
	List<Tag> tags;
	List<Attribute> attributes;

	Object getAttributeValue(String key) {
		return attributes.stream()
				.filter(attribute -> attribute.getKey().equals(key))
				.map(Attribute::getValue)
				.findFirst()
				.orElse(null);
	}

	void execute() {
		
	}
}
