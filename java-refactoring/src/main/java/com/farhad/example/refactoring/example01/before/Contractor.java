package com.farhad.example.refactoring.example01.before;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class Contractor {
  
    private int accountNumber;
    private int salary ;
    private int commission ;

    public void makePayment() {
        log.info("Processing payment for {} amount: {}", accountNumber, (salary - commission) );
    }

}
