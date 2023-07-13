package com.farhad.example.anotherddd;

import java.math.BigDecimal;

// balance calculator domain service
public interface BalanceCalculator {
    BigDecimal calculate(Fee fee);
}
