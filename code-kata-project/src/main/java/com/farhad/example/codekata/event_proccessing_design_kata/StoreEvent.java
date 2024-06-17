package com.farhad.example.codekata.event_proccessing_design_kata;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StoreEvent {
    private long storeProfile;
    private String name;
    private String storeType;
}
