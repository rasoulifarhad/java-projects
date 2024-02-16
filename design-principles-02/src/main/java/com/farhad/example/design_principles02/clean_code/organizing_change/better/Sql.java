package com.farhad.example.design_principles02.clean_code.organizing_change.better;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Sql {

	private final String table;
	private final Column[] Columns;


	public abstract String generate();
}
