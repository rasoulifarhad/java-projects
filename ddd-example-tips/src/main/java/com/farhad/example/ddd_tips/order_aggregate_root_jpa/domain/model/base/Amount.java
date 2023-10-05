package com.farhad.example.ddd_tips.order_aggregate_root_jpa.domain.model.base;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Amount {

    private int value;
}
