package com.farhad.example.design_principles02.elegant_objects_book.method_names.static_method;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WebPage {

	private final String uri;

	public String content() {
		// make HTTP request and convert
		// the response into a UTF-8 string
		return "";

	}
}
