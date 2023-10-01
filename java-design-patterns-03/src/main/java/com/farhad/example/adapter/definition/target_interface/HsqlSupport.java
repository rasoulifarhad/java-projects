package com.farhad.example.adapter.definition.target_interface;

import static com.farhad.example.adapter.app.Db.gConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HsqlSupport implements HsqlAccessor {


    @Override
    public ResultSet select(String query, List<String> parametrs) {
        try  {
            Connection conn = gConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            for (int i = 0; i < parametrs.size(); i++) {
                statement.setString(i+1, parametrs.get(i));
            }

            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int update(String query, List<String> parameters) {
        try (Connection conn = gConnection();
                PreparedStatement statement = conn.prepareStatement(query)) {
            for (int i = 0; i < parameters.size(); i++) {
                statement.setString(i+1, parameters.get(i));
            }
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    
}
