package com.farhad.example.concurrent.concurrencymodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcurrencyModelDemo {
    

    public void demonstrateRunAsync() {
        log.info("");
        Runnable task = () -> log.info("Executed!");
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(task);
        log.info("start joining....");
        completableFuture.join();
    }

    public void demonstrateSupplyAsync() {
        log.info("");
        Supplier<Long> idGenerator = idGenerator();
        List<CompletableFuture<Long>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CompletableFuture<Long> cf = CompletableFuture.supplyAsync(idGenerator);
            futures.add(cf);
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture [0]));
    }

    public void demonstrateSupplyAsyncWithExecutorService() throws Exception {
        log.info("");
        Supplier<Long> idGenerator = idGenerator();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<Long> cf = CompletableFuture.supplyAsync(idGenerator, executorService);
        log.info("joining.....");
        cf.join();
        log.info("Id: {}", cf.get());
        executorService.shutdown();
    }

    public void demonstrateSupplyAsyncWithCallback() {
        log.info("");
        Supplier<Long> idGenerator = idGenerator();
        CompletableFuture<Long> cf = CompletableFuture.supplyAsync(idGenerator);
        cf.thenAccept(i -> log.info("Acceptted Id: {}", i));
        cf.join();
        log.info("Finished!..");
    }

    public void demonstrateCompletableFutureCompleteThenAccept() {
        log.info("");
        CompletableFuture<String> cf = new CompletableFuture<>();
        cf.thenAccept(s -> log.info("{}", s));
        log.info("completing");
        cf.complete("Hello Farhad");
        cf.join();
    }

    public void demonstrateCompletableFutureCompleteThenAcceptAsync() {
        log.info("");
        CompletableFuture<String> cf = new CompletableFuture<>();
        cf.thenAcceptAsync(s -> log.info("{}", s));
        log.info("completing");
        cf.complete("Hello farhad async");
        cf.join();
    }

    public void demonstrateCompletableFutureCompleteThenApply() {
        log.info("");
        CompletableFuture<String> cf = new CompletableFuture<>();
        cf.thenApply(s -> s.toUpperCase())
          .whenComplete((s, err) -> log.info("{}", s));
        log.info("completing");
        cf.complete("Hello Farhad apply to uppercase");
        cf.join();
    }

    public void demonstrateCompletableFutureCompleteThenApplyAsync() {
        log.info("");
        CompletableFuture<String> cf = new CompletableFuture<>();
        cf.thenApplyAsync(s -> s.toUpperCase())
          .whenComplete((s, err) -> log.info("{}", s));
        log.info("completing");
        cf.complete("Hello Farhad apply to uppercase async");
        cf.join();
    }

    public void demonstrateCompletableFutureCompleteThenRun() {
        log.info("");
        CompletableFuture<Void> cf = new CompletableFuture<>();
        cf.thenRun(() -> log.info("Hello farhad run."));
        log.info("completing");
        cf.complete(null);
        cf.join();
    }

    public void demonstrateCompletableFutureCompleteThenRunAsync() {
        log.info("");
        CompletableFuture<Void> cf = new CompletableFuture<>();
        cf.thenRunAsync(() -> log.info("Hello farhad run async."));
        log.info("completing");
        cf.complete(null);
        cf.join();
    }
    
    //       click
    // user -------> register ----> create user ----> register address --------------- 
    //                                     |                                          |
    //                                     |                                          V
    //                                     ---------> create payment details ----> send mail
    //                                                                         
    public void register(User user ) {

        // CompletableFuture<Void> chain = new CompletableFuture<>();

        // CompletableFuture<String> cf =  chain.thenComposeAsync(nil -> createUser());
        // CompletableFuture<Void> cf2 = cf.thenAcceptAsync(s -> log.info("{}",s));
        // CompletableFuture<?> cf3 =  cf2.thenComposeAsync(nil -> 
        //     registerAddress()
        // );
    }


    public String createUser() {
        User user = new User(UUID.randomUUID()); 
        return user.getUserId().toString();
    }

    public void loglogNewUserId() {

    }

    public String registerAddress() {
        return "Address";
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class User {
        private UUID userId;

    }

    public static void main(String[] args) throws Exception {
        ConcurrencyModelDemo demo = new ConcurrencyModelDemo();
        demo.demonstrateRunAsync();
        demo.demonstrateSupplyAsync();
        demo.demonstrateSupplyAsyncWithExecutorService();
        demo.demonstrateSupplyAsyncWithCallback();
        demo.demonstrateCompletableFutureCompleteThenAccept();
        demo.demonstrateCompletableFutureCompleteThenAcceptAsync();
        demo.demonstrateCompletableFutureCompleteThenApply();
        demo.demonstrateCompletableFutureCompleteThenApplyAsync();
        demo.demonstrateCompletableFutureCompleteThenRun();
        demo.demonstrateCompletableFutureCompleteThenRunAsync();
    }

    private Supplier<Long> idGenerator() {
        AtomicLong id = new AtomicLong();
        return () -> {
            id.incrementAndGet();
            // log.info("Generatiung id {} ....", id.get());
            sleep();
            return id.get();
        };
    }
    private static final int HIGH_SLEEP_TIME_BOUND = 2000;
    private void sleep() {
                Random rnd = new Random();
                sleep( rnd.nextInt(HIGH_SLEEP_TIME_BOUND) );
    }

    private void sleep(long time) {
            try {
                Thread.sleep( time );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

}
