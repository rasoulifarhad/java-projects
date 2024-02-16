package com.farhad.example.design_principles02.clean_code.organizing_change.bad;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Sql {

	private final String table;
	private final Column[] Columns;

	public String create() {
		return "";
	}

	public String insert(Object[] fields) {
		return "";
	}

	public String selectAll() {
		return "";
	}

	public String findByKey(String keyColumn, String keyValue) {
		return "";
	}

	public String select(Column column, String pattern) {
		return "";
	}

	public String select(Criteria criteria) {
		return "";
	}

	public String preparedInsert() {
		return "";
	}

	private String columnList(Column[] columns) {
		return "";
	}

	private String valuesList(Object[] fields, final Column[] columns) {
		return "";
	}

	private String selectWithCriteria(String criteria) {
		return "";
	}

	private String placeHolderList(Column[] columns) {
		return "";
	}

}
