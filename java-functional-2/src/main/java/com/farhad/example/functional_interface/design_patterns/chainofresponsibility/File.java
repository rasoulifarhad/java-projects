package com.farhad.example.functional_interface.design_patterns.chainofresponsibility;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class File {

	private final FileType type;
	private final String content;
}
