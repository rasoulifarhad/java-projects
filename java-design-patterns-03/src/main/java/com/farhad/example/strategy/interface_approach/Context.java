package com.farhad.example.strategy.interface_approach;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public class Context {
    
    @Setter
    private Strategy<String, String> strategy;

    public void executeStrategy() {
        String res = strategy.execute("Who are you?");
        System.out.println(res);
    }

    public static void main(String[] args) {
        Context context = new Context(Strategies.strategyA);
        context.executeStrategy();
        context.setStrategy(Strategies.strategyB);
        context.executeStrategy();

        context.setStrategy(s -> "sdsdsdsddddddddd");
        context.executeStrategy();
    }
}
