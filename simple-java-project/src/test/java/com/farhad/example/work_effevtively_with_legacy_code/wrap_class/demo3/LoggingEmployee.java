package com.farhad.example.work_effevtively_with_legacy_code.wrap_class.demo3;

import java.util.Date;

public class LoggingEmployee extends Employee {

    private final Employee employee;

    public LoggingEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void pay(Date date) {
        logPasyment();
        employee.pay(date);
    }

    private void logPasyment() {
    }

    
}
