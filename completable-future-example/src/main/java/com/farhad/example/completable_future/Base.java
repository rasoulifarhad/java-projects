package com.farhad.example.completable_future;

import java.util.concurrent.CompletableFuture;

public class Base {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> "Hello world")
            .thenApply(String::toUpperCase)
            .thenAccept(System.out::println);
   }
}
