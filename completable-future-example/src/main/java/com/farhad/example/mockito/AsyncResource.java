package com.farhad.example.mockito;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

import com.farhad.example.mockito.AsyncResponse.StringResult;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AsyncResource {
    private ExecutorService executor;

    public CompletableFuture<StringResult> executeAsync(AsyncResponse response) {
        return CompletableFuture.supplyAsync(() -> response.longOperation(), executor);
    }
}
