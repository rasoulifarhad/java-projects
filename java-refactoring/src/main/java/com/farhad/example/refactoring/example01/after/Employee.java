package com.farhad.example.refactoring.example01.after;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class Employee {
   
    int accountNumber;
    int salary ;

    Converter<Object, String> converter ;

    public void makePayment() {
       log.info("Processing payment for {} amount: {}", accountNumber, salary); 
    }

    public void printReport() {
        log.info("printing regiular employee details in json format: {}", converter.serialize(this));
    }
}
