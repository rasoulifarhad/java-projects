package com.farhad.example.strategy.enum_approach;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public class Context {
    
    @Setter
    private Strategies strategy;

    public void executeStrategy () {
        String res = strategy.execute("Who are you?");
        System.out.println(res);
    }
    
    public static void main(String[] args) {
        Context context = new Context(Strategies.STRATEGYA);
        context.executeStrategy();
        context.setStrategy(Strategies.STRATEGYB);
        context.executeStrategy();
    }

}
