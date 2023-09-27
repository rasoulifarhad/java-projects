package com.farhad.example.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Demo01 {
    
    public static void main(String[] args) {
        
        test1();
        System.out.println("=====");
        test2();
        System.out.println("=====");
        test3();
    }

    private static void test1() {
        CompletableFuture<String> closing = new CompletableFuture<>();
        Stream<String> manyStrings = Stream.of("one", "two", "three");

        BinaryOperator<String> binaryOperator =  (s1, s2) -> s1 + s2;

        CompletableFuture<String> reduce =
            manyStrings
                .onClose(() -> closing.complete(""))
                .map(CompletableFuture::completedFuture)
                .filter(cf -> {
                    try {
                        return cf.get().length() < 20;
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                })
                .reduce(
                    closing,
                    (cf1, cf2) -> cf1.thenCombine(cf2, binaryOperator));
        manyStrings.close();
        System.out.println(reduce.join());
    }

    private static void test2() {
        CompletableFuture<String> closing = new CompletableFuture<>();
        Stream<String> manyStrings = Stream.of("one", "two", "three");

        BinaryOperator<String> binaryOperator =  (s1, s2) -> s1 + s2;

        CompletableFuture<String> reduce =
            manyStrings.parallel()
                .onClose(() -> closing.complete(""))
                .map(CompletableFuture::completedFuture)
                .filter(cf -> {
                    try {
                        return cf.get().length() < 20;
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                })
                .reduce(
                    closing,
                    (cf1, cf2) -> cf1.thenCombine(cf2, binaryOperator));
        manyStrings.close();
        System.out.println(reduce.join());
    }

    private static void test3() {
        CompletableFuture<String> closing = new CompletableFuture<>();
        Stream<String> manyStrings = Stream.of("one", "two", "three");

        BinaryOperator<String> binaryOperator =  (s1, s2) -> s1 + s2;
            CompletableFuture<String> reduce =
                manyStrings.parallel()
                    .onClose(() -> closing.complete(""))
                    .map(CompletableFuture::completedFuture)
                    .filter(cf -> {
                        try {
                            return cf.get().length() < 20;
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        } catch (ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .reduce(
                        closing,
                        (cf1, cf2) -> cf1.thenCombine(cf2, binaryOperator));
            manyStrings.close();

        ForkJoinPool fk = new ForkJoinPool(4);
        CompletableFuture<Void> res =reduce.thenAcceptAsync(t -> System.out.println(t), fk);
        res.join();
        
    }
}
