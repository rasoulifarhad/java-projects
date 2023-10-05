package com.farhad.example.documents_contracts;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class ContractViolation {
    private String id;
    private String message;

    public String id() {
        return id;
    }
}
