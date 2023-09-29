package com.farhad.example.strategy.standard_approach;

public class StrategyA implements Strategy<String, String> {

    @Override
    public String execute(String s) {
        System.out.println(s);
        return "StrategyA";
    }
    
}
