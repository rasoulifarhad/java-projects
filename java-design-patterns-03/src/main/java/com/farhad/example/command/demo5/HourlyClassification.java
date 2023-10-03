package com.farhad.example.command.demo5;

import java.time.LocalDateTime;
import java.util.List;

public class HourlyClassification implements PayClassification{

    private double hourlyPay;
    private List<TimeCard> timeCards;

    @Override
    public void calculatePay() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculatePay'");
    }
    
    public static class TimeCard {
        private LocalDateTime date;
        private int hours;
    }
}
