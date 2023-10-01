package com.farhad.example.adapter.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
    
    private static String db = "jdbc:h2:~/test";
    private static String user = "sa";
    private static String password = "";
    private static String driver = "org.h2.Driver";

    static String createQuery = "CREATE TABLE IF NOT EXISTS METRIC_METADATA (METRIC_METADATA_ID VARCHAR(255) NOT NULL PRIMARY KEY, METRIC_NAME VARCHAR(255), METRIC_VALUE_TYPE VARCHAR(255))";

    public static Connection gConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(db, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);

        }
        return connection;    
    }

    public static void initDb()  {

        Connection conn;
        try {
            conn = gConnection();
            Statement createStatement = conn.createStatement();
            createStatement.execute(createQuery);
            createStatement.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }    
}
