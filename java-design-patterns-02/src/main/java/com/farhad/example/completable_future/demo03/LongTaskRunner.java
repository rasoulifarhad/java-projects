package com.farhad.example.completable_future.demo03;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class LongTaskRunner {
    
    public static CompletableFuture<String> longTaskRun(int taskId,ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            LongTaskService service = new LongTaskService();
            return service.longTask(taskId);
        }, executor);
    }
}
