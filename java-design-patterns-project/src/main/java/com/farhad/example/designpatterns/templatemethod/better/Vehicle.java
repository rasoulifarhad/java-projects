package com.farhad.example.designpatterns.templatemethod.better;

import java.util.function.Consumer;


public interface Vehicle {
     
     default void start(Consumer<Void> preStartCheck) {
          preStartCheck.accept(null);
          System.out.println( String.format("%s starting....", this.getClass().getSimpleName()));
     }
}
