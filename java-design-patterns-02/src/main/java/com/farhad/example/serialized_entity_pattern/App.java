package com.farhad.example.serialized_entity_pattern;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    
    private static final  String DB_URL = "jdbc:h2:~/test";

    private App() {

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final DataSource dataSource = createDataSource();
        deleteSchema(dataSource);
        createSchema(dataSource);

        Country iran = new Country(
            98 , 
            "Iran", 
            "Asia", 
            "Persian");
        final Country china = new Country(
            86, 
            "China", 
            "Asia", 
            "Chinese");
        final CountryEchemaSql serializedIran = new CountryEchemaSql(iran, dataSource);
        final CountryEchemaSql serializedChina = new CountryEchemaSql(china, dataSource);

        serializedIran.insertCountry();
        serializedChina.insertCountry();

        serializedIran.selectCountry();
        serializedChina.selectCountry();

    }

    private static void createSchema(DataSource dataSource) {
        try (Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement()) {
            statement.execute(CountryEchemaSql.CREATE_SCHEMA_SQL);
        } catch (Exception e) {
            log.info("Exception thrown " + e.getMessage());
        }
    }

    private static void deleteSchema(DataSource dataSource) {
        try (Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement()) {
            statement.execute(CountryEchemaSql.DELETE_SCHEMA_SQL);
        } catch (Exception e) {
            log.info("Exception thrown " + e.getMessage());
        }
    }

    private static DataSource createDataSource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL(DB_URL);
        return dataSource;
    }
}
