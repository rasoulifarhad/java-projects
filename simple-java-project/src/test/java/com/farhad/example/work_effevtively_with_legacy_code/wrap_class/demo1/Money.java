package com.farhad.example.work_effevtively_with_legacy_code.wrap_class.demo1;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Money {

    @Getter
    private double amount;


    public void add(double value) {
        this.amount += value;
    }

}
