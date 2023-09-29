package com.farhad.example.strategy.standard_approach;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
public class Context {
    
    @Setter
    @NonNull
    private Strategy<String, String> strategy;

    public void executeStrategy() {
        String res = strategy.execute("Who are you?");
        System.out.println(res);
    }

    public static void main(String[] args) {
        Context context = new Context(new StrategyA());
        context.executeStrategy();
        System.out.println();
        context.setStrategy(new StrategyB());
        context.executeStrategy();
    }
}
