package com.farhad.example.generic.emulating_self_types_with_generics;

import java.util.List;
import java.util.stream.Stream;

import lombok.Getter;

@Getter
public abstract class NodeScaffold<THIS extends NodeScaffold<THIS>> {
	private List<THIS> children;

	public Stream<THIS> children() {
		return children.stream();
	}

	public Stream<THIS> grandChildren() {
		return children.stream()
				.flatMap(child -> child.children());
	}
}
