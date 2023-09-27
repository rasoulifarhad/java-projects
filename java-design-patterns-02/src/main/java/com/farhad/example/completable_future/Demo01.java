package com.farhad.example.completable_future;

import java.util.concurrent.CompletableFuture;

public class Demo01 {
    
    public static void main(String[] args) {
        
        CompletableFuture.supplyAsync(() -> "Hello world")
            .thenApply(String::toUpperCase)
            .thenAccept(System.out::println);
    }
}
