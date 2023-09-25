package com.farhad.example.serialized_entity_pattern;

import static java.util.Objects.requireNonNull;

import java.io.IOException;

import javax.activation.DataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CountryEchemaSql {
	
	public static final String CREATE_SCHEMA_SQL = "CREATE TABLE IF NOT EXISTS WORLD (ID INT PRIMARY KEY, COUNTRY BLOB)";

	public static final String DELETE_SCHEMA_SQL = "DROP TABLE WORLD IF EXISTS";

	private Country country;
	private DataSource dataSource;

	public CountryEchemaSql(Country country, DataSource dataSource) {
		requireNonNull(country);
		requireNonNull(dataSource);
		this.country = new Country(
					country.getCode(), 
					country.getName(), 
					country.getContinents(), 
					country.getLanguage());
		this.dataSource = dataSource;
	}

	public int insertCountry() throws IOException {
		String sql = "INSERT INTO WORLD (ID, COUNTRY) VALUES (?, ?)";
	}
}
