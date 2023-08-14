package com.farhad.example.designpatterns.anotherspecification.newera;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Criteria implements SearchCriteria {

    private final List<SearchCriteria> criterias;


    @Override
    public boolean isSatisfiedBy(Product product) {
        for (SearchCriteria searchCriteria : criterias) {
            if( !searchCriteria.isSatisfiedBy(product) ) {
                return false;
            }            
        }
        return true;
    }
    
}
