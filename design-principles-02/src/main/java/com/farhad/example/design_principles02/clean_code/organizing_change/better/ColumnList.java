package com.farhad.example.design_principles02.clean_code.organizing_change.better;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ColumnList {

	private final Column[] columns;

	public String generate() {
		return "";
	}
}
