package com.farhad.example.completable_future.demo03;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = ForkJoinPool.commonPool();
        
        testCompletableFutureSequence(executor);
        

        executor.shutdown();

        testCompletableFutureComposition();
    }

    private static void testCompletableFutureSequence(ExecutorService executor) {
        long start = System.currentTimeMillis();

        List<CompletableFuture<String>> futureList =
            IntStream.range(0, 20).boxed()
                .map(i ->  
                    LongTaskRunner.longTaskRun(i, executor)
                        .exceptionally(t -> t.getMessage()))
                .collect(toList());

        CompletableFuture<List<String>> results = 
            CompletableFuture.allOf(
                        futureList.toArray(new CompletableFuture [0]))
                .thenApply(
                    v -> futureList.stream()
                                .map(CompletableFuture::join)
                                .collect(toList()));

        System.out.println(results.join());
        System.out.println("Time took: " + (System.currentTimeMillis() - start));

    }

    private static void testCompletableFutureComposition() throws InterruptedException, ExecutionException  {
        
        Double priceInEuro = CompletableFuture.supplyAsync( () -> 
                getStockPrice("GOOGL"))
            .thenCombine(
                CompletableFuture.supplyAsync( () -> 
                            getExchangeRate("USD", "EUR")), 
                (stockPrice, exchangeRate) -> convertPrice(stockPrice, exchangeRate))
                .exceptionally(t -> {
                    System.out.println("Error " + t.getMessage());
                    return -1d;
                }).get();

        System.out.println("Price: " + priceInEuro);

    }

    private static Double getStockPrice(String stock) {
        try {
            Thread.sleep(1000L);
            return Double.parseDouble("100");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static Double getExchangeRate(String fromCurrency, String toCurrency) {
        try {
            Thread.sleep(1000L);
            return Double.parseDouble("0.2");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static Double convertPrice(Double stockPrice, Double exchangeRate) {
        return new Double(stockPrice * (1 - exchangeRate));
    }

}
