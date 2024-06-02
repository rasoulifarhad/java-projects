package com.farhad.example.work_effevtively_with_legacy_code.wrap_class.demo3;

import java.util.Date;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoggingPayDispatcher {

    private final Employee employee;

    public void pay(Date date) {
        employee.pay(date);
        logPayment();
    }

    private void logPayment() {
    }
}
