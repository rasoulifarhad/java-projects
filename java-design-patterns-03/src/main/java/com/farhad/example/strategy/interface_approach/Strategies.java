package com.farhad.example.strategy.interface_approach;

public interface Strategies  {
    
    Strategy<String, String> strategyA = s -> {
        System.out.println(s);
        return "StrategyA";
    };

    Strategy<String, String> strategyB = s -> {
        System.out.println(s);
        return "StrategyB";
    };

}
