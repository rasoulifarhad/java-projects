package com.farhad.example.adapter.app;

import java.sql.SQLException;
import java.util.UUID;

import com.farhad.example.adapter.definition.adapter_interface.HsqlAdapter;
import com.farhad.example.adapter.definition.existing_interface.DbType;
import com.farhad.example.adapter.definition.target_interface.HsqlSupport;
import com.farhad.example.adapter.model.MetricMetadataMapper;

public class App {
    
    static String insertQuery = "INSERT INTO METRIC_METADATA VALUES (?, ?, ?)";
    static String searchQuery = "SELECT * FROM METRIC_METADATA WHERE METRIC_METADATA_ID=?";


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Db.initDb();

        DbType db = new HsqlAdapter(new HsqlSupport());
        String id = UUID.randomUUID().toString();
        System.out.println(db.update(insertQuery, new String[] {id, "paraam-"+ id, "param-value-" + id}));
        System.out.println(db.query(searchQuery, new String[] {id}, new MetricMetadataMapper()));

    }



}
