package com.farhad.example.strategy.demo1;

public interface Application {
    void init();
    void idle();
    void cleanup();
    boolean done();
}
