package com.farhad.example.work_effevtively_with_legacy_code.sprout_class.demo3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private String department;
    private String manager;
    private int netProfit;
    private int operationExpense;

}
