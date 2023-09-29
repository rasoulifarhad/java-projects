package com.farhad.example.strategy.enum_approach;

public enum Strategies {
    STRATEGYA{

        @Override
        public String execute(String s) {
            System.out.println(s);
            return "STRATEGYA";
        }

    }, 
    STRATEGYB{

        @Override
        public String execute(String s) {
            System.out.println(s);
            return "STRATEGYB";
        }
    };

    public abstract String execute(String s);
}
