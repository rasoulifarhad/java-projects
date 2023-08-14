package com.farhad.example.designpatterns.anotherspecification.newera;

import com.farhad.example.designpatterns.anotherspecification.newera.SearchCriteriaBuilder.Operator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PriceCritrion implements SearchCriteria {

    private final Operator operator;
    private final double targetPrice;
    

    @Override
    public boolean isSatisfiedBy(Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isSatisfiedBy'");
    }


    
}
