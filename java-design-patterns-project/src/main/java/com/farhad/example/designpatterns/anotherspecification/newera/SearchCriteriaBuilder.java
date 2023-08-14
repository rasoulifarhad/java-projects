package com.farhad.example.designpatterns.anotherspecification.newera;

import java.util.ArrayList;
import java.util.List;

public class SearchCriteriaBuilder {
    
    protected List<SearchCriteria> criterias  = new ArrayList<>();

    PriceCriteriaBuilder priceCriteriaBuilder;

    public PriceCriteriaBuilder withPrice() {
        if (priceCriteriaBuilder == null) {
            priceCriteriaBuilder = new PriceCriteriaBuilder();
        }
        return priceCriteriaBuilder;
    }

    public PriceCriteriaBuilder and() {
        return priceCriteriaBuilder;
    }

    public SearchCriteria build() {
        return new Criteria(criterias);
    }

    public enum Operator {
        
            lessThan,
            equals,
            largerThan;
    }

    public class PriceCriteriaBuilder {
    
        Operator operator;
        double targetPrice;
        
        public PriceCriteriaBuilder being(Operator operator) {
            this.operator = operator;
            return this;
        }   
    
        public PriceCriteriaBuilder value(double value) {
            this.targetPrice = value;
            criterias.add(new PriceCritrion(operator, value));
            return PriceCriteriaBuilder.this; 
        }
    }
    
}
