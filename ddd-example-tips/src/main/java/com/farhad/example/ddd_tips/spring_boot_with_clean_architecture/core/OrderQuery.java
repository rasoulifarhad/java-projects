package com.farhad.example.ddd_tips.spring_boot_with_clean_architecture.core;

import java.time.Instant;
import java.util.UUID;

import com.farhad.example.ddd_tips.spring_boot_with_clean_architecture.app.Params;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class OrderQuery {
    
    private UUID userId;
    private Instant since;
    public static OrderQuery from(Params params) {
        return null;
    }
}
