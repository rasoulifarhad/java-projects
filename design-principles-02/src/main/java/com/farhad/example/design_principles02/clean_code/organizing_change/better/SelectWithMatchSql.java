package com.farhad.example.design_principles02.clean_code.organizing_change.better;

public class SelectWithMatchSql extends Sql {

	public SelectWithMatchSql(String table, Column[] Columns) {
		super(table, Columns);
	}

	@Override
	public String generate() {
		return "";
	}

}
