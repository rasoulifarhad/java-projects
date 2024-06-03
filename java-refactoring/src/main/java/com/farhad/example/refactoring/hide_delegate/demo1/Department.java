package com.farhad.example.refactoring.hide_delegate.demo1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Department {


    private String chargeCode;
    private Manager manager;
}
