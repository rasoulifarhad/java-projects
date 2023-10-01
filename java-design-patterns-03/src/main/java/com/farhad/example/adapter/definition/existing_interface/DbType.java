package com.farhad.example.adapter.definition.existing_interface;

import java.util.List;

import com.farhad.example.adapter.model.Model;


public interface DbType {
    public <T extends Model> List<T> query(String query, String [] parameters, RowMapper<T> rowMapper);
    public int update(String query, String [] parameters);
}
