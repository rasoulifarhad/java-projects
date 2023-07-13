package com.farhad.example.anotherddd;

import java.math.BigDecimal;
import java.util.stream.StreamSupport;

// So what does the BalanceCalculatorImpl need to do its job properly?  
//
// From the Fee object, it needs:
// 
//  - List of payments
//  - Fee amount
// 
// And from each Payment object, the Amount. 
// 
public class BalanceCalculatorImpl implements BalanceCalculator {

    @Override
    public BigDecimal calculate(Fee fee) {
        Iterable<Payment> payments = fee.payments();
        BigDecimal totalApplied =  
            StreamSupport
                .stream(payments.spliterator(), false)
                .map(Payment::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return fee.getAmount().subtract(totalApplied);
    }
    
}
