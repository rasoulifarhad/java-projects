package com.farhad.example.anotherddd;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {
    
    private boolean atRisk;

    private List<Fee> fees = new ArrayList<>();

    public Iterable<Fee> fees() {
        return Collections.unmodifiableList(fees);
    }
    
    public Fee chargeFee(BigDecimal amount) {
        Fee fee = new Fee(amount, this);
        fees.add(fee);
        return fee;
    }

    public void updateAtRiskStatus() {
        int totalWithOutstandingBalance = (int) fees.stream()
                                                        .filter(Fee::hasOutstandingBalance)
                                                        .count();
        atRisk = totalWithOutstandingBalance > 3; 
    }
}
