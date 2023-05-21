package com.farhad.example.refactoring.example01.after;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Contractor extends Employee{
  
    private int commission ;

    
    public Contractor(int accountNumber, int salary, int commission, Converter<Object, String> converter) {
        super(accountNumber, salary, converter);
        this.commission = commission;
    }


    @Override
    public void makePayment() {
        log.info("Processing payment for {} amount: {}", accountNumber, (salary - commission) );
    }

    public void printReport() {
        log.info("printing contractor details in xml format: {}", converter.serialize(this));
    }

}
