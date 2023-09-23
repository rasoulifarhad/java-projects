package com.farhad.example.codekata.Bank_kata.impl2.acceptancetests;

import java.lang.reflect.Type;

import org.jbehave.core.steps.ParameterConverters.ParameterConverter;

import com.farhad.example.codekata.Bank_kata.impl2.domain.Amount;

public class AmountConverter  implements ParameterConverter<Amount> {

    @Override
    public boolean accept(Type type) {
        if (type instanceof Class<?>) {
			return Amount.class.isAssignableFrom((Class<?>) type);
		}
		return false;   
    }

    @Override
    public Amount convertValue(String value, Type type) {
		return Amount.amountOf(Integer.valueOf(value));   
    }

    
}
