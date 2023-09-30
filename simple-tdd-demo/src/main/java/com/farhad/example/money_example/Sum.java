package com.farhad.example.money_example;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Sum implements Expression{

    private Money addend;
    private Money augend;
}
