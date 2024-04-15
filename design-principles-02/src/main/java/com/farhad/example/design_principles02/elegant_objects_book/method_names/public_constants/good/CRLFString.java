package com.farhad.example.design_principles02.elegant_objects_book.method_names.public_constants.good;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class CRLFString {

	private final String origin;

	@Override
	public String toString() {
		return String.format("%s\r\n", origin);
	}

}
