package com.farhad.example.adapter.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.farhad.example.adapter.definition.existing_interface.RowMapper;

public class MetricMetadataMapper implements RowMapper<MetricMetadata> {

    @Override
    public MetricMetadata mapRow(ResultSet rs, int rowNum) throws SQLException {
        MetricMetadata row = new MetricMetadata();
        row.setId(rs.getString("METRIC_METADATA_ID"));
        row.setMetricName(rs.getString("METRIC_NAME"));
        row.setMetricValueType(rs.getString("METRIC_VALUE_TYPE"));
        return row;
    }
    
}
