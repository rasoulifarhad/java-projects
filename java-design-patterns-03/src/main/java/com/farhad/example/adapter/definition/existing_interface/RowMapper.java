package com.farhad.example.adapter.definition.existing_interface;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.farhad.example.adapter.model.Model;

public interface RowMapper<T extends Model> {
    T mapRow(ResultSet rs, int rowNum) throws SQLException;
}
