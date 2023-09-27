package com.farhad.example.completable_future.demo02;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Transaction {
    
    private String id;
    private String description;
}
