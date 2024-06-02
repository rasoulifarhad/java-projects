package com.farhad.example.work_effevtively_with_legacy_code.wrap_method.demo03;

import java.util.Date;
import java.util.List;

public class Employee {

    private PayDispatcher payDispatcher;
    private List<TimeCard> timeCards;
    private List<Date> payPeriod;
    private double payRate;

    public void makeLoggedPaymrnt(Date date) {
        logPayment();
        Money amount = calculatePay(date);
        dispatchPayment(amount, date);
    }

    private void dispatchPayment(Money amount, Date date) {
        payDispatcher.pay(this, date, amount);
    }

    private Money calculatePay(Date date) {
        Money amount = new Money(0.0);
        for (TimeCard timeCard : timeCards) {
            if (payPeriod.contains(date)) {
                amount.add(timeCard.getHours() * payRate);
            }
        }
        return amount;
    }

    private void logPayment() {
    }
}
