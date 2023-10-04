package com.farhad.example.serialized_entity_pattern;

import static java.util.Objects.requireNonNull;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CountryEchemaSql implements CountryDao {
	
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

@Override
	public int insertCountry() throws IOException {
		String sql = "INSERT INTO WORLD (ID, COUNTRY) VALUES (?, ?)";
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(baos)){

			oos.writeObject(country);
			oos.flush();
			statement.setInt(1, country.getCode());
			statement.setBlob(2, new ByteArrayInputStream(baos.toByteArray()));
			statement.execute();
			return country.getCode();
		} catch (Exception e) {
			log.info("Exception thrown " + e.getMessage());
		}
		return -1;
	}

	@Override
	public int selectCountry() throws IOException, ClassNotFoundException {
		String sql = "SELECT ID, COUNTRY FROM WORLD WHERE ID =?";
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, country.getCode());

			try (ResultSet rs = statement.executeQuery()) {
				if(rs.next()) {
					Blob countryBlob = rs.getBlob("country");
					ByteArrayInputStream bais = new ByteArrayInputStream(countryBlob.getBytes(1, (int)countryBlob.length()));
					ObjectInputStream ois = new ObjectInputStream(bais);
					country = (Country) ois.readObject();
					log.info("Country: " +  country);
				}
				return country.getCode();
			}
		} catch (Exception e) {
			log.info("Exception trown: " + e.getMessage());
		}
		return -1;
	}
}
