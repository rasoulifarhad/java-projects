package com.farhad.example.adapter.definition.adapter_interface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.farhad.example.adapter.definition.existing_interface.DbType;
import com.farhad.example.adapter.definition.existing_interface.RowMapper;
import com.farhad.example.adapter.definition.target_interface.HsqlAccessor;
import com.farhad.example.adapter.model.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HsqlAdapter implements DbType {

    private HsqlAccessor hsqlAccessor;

    @Override
    public <T extends Model> List<T> query(String query, String[] parameters, RowMapper<T> rowMapper) {
        ResultSet resultSet;
        try {
            resultSet = hsqlAccessor.select(query, Arrays.asList(parameters));
            return convertResultSet(resultSet, rowMapper);

        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.<T>emptyList();
        }
    }

    private <T extends Model> List<T> convertResultSet(ResultSet rs, RowMapper<T> rowMapper) throws SQLException {
        List<T> l = new ArrayList<>();
        int r = 0; 
        while(rs.next()) {
            T t = rowMapper.mapRow(rs,r);
            l.add(t); 
        }
        return l;
    }

    @Override
    public int update(String query, String[] parameters) {
        try {
            return hsqlAccessor.update(query, Arrays.asList(parameters));
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    
}
