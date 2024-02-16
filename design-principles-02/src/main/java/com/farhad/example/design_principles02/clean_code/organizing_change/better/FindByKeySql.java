package com.farhad.example.design_principles02.clean_code.organizing_change.better;

public class FindByKeySql extends Sql {

	public FindByKeySql(String table, Column[] Columns) {
		super(table, Columns);
	}

	@Override

	public String generate() {
		return "";
	}

}
