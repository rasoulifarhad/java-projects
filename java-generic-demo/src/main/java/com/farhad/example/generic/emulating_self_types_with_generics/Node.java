package com.farhad.example.generic.emulating_self_types_with_generics;

import java.util.List;
import java.util.stream.Stream;

import lombok.Getter;

@Getter
public class Node<THIS> {
	private List<THIS> children;

	public Stream<? extends THIS> children() {
		return children.stream();
	}
}
