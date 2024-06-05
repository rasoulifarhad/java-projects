package com.farhad.example.refactoring.static_substitution.refactored;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class AddressBook {

    private static AddressBook instance = new AddressBook();

    private String connectionString, username, password;

    
    public AddressBook() {
        Properties props = getProperties();
        this.connectionString = props.getProperty("db.connectionString");
        this.username = props.getProperty("db.username");
        this.password = props.getProperty("db.password");

    }

    public static Person findByLastName(String s) {
        return instance.findByLastNameImpl(s);
    }

    public Person findByLastNameImpl(String s) {
        String query = "SELECT lastName, firstName FROM PEOPLE WHERE lastname = ?";
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(connectionString, username, password);
            st = conn.prepareStatement(query);
            rs = st.executeQuery();
            rs.next();
            Person person = new Person(rs.getString(2), rs.getString(1));
            return person;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            cleanUp(conn, st, rs);
        }

    }

    private static void cleanUp(Connection conn, PreparedStatement st, ResultSet rs) {
    }

    private static Properties getProperties() {
        return new Properties();
    }
}
