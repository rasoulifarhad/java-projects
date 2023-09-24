package com.farhad.example.promise;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Function;

import lombok.RequiredArgsConstructor;

/**
 * A Promise represents a proxy for a value not necessarily known when the promise is created. It
 * allows you to associate dependent promises to an asynchronous action's eventual success value or
 * failure reason. This lets asynchronous methods return values like synchronous methods: instead 
 * of the final value, the asynchronous method returns a promise of having a value at some point 
 * in the future.
 * 
 */
public class Promise<T> extends PromiseSupport<T> {
    
    private Runnable fulfillmentAction;
    private Consumer<? super Throwable> exceptionHandler;

    public Promise() {
    }

    @Override
    void fulfill(T value) {
        super.fulfill(value);
        postFulfillment();
    }

    

    @Override
    void fulfillExceptionally(Exception exception) {
        super.fulfillExceptionally(exception);
        handleException(exception);
        postFulfillment();
    }

    private void handleException(Exception exception) {
        if(exceptionHandler == null) {
            return;
        }
        exceptionHandler.accept(exception);
    }

    private void postFulfillment() {
        if(fulfillmentAction == null) {
            return;
        }
        fulfillmentAction.run();
    }

    public Promise<T> fulfillInAsync(final Callable<T> task, Executor executor) {
        executor.execute(() -> {
            try {
                fulfill(task.call());
            } catch (Exception e) {
                fulfillExceptionally(e);
            }
        });
        return this;
    }

    public Promise<Void> thenAccept(Consumer<? super T> action) {
        Promise<Void> dest = new Promise<>();
        fulfillmentAction = new ConsumeAction(this, dest, action);
        return dest;
    }

    public <V> Promise<V> thenApply(Function<? super T, V> func) {
        Promise<V> dest = new Promise<>();
        fulfillmentAction = new TransformAction<V>(this, dest, func);
        return dest;
    }

    public Promise<T> onError(Consumer<? super Throwable> exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
        return this;
    }

    @RequiredArgsConstructor
    private class ConsumeAction implements Runnable {

        private final Promise<T> src;
        private final Promise<Void> dest;
        private final Consumer<? super T> action;

        @Override
        public void run()  {
            try {
                action.accept(src.get());
                dest.fulfill(null);
            } catch (Throwable e) {
                dest.fulfillExceptionally((Exception)e.getCause());
            }
        }

    }

    @RequiredArgsConstructor
    private class TransformAction<V> implements Runnable {

        private final Promise<T> src;
        private final Promise<V> dest;
        private final Function<? super T, V> func;
       
        @Override
        public void run() {
            try {
                dest.fulfill(func.apply(src.get()));
            } catch (Exception e) {
                dest.fulfillExceptionally((Exception) e.getCause());            }
        }
    
    }
}
