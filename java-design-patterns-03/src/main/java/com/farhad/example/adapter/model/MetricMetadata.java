package com.farhad.example.adapter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MetricMetadata  implements Model {
    
    private static final long serialVersionUID = 123343;
    
    private String id;
    private String metricName;
    private String metricValueType;

}
