## CompletableFuture

**Extract/modify wrapped value**

Typically futures represent piece of code running by other thread. But that's not always the case. Sometimes you want to create a Future representing some event that you know will occur, e.g. JMS message arrival. So you have Future<Message> but there is no asynchronous job underlying this future. You simply want to complete (resolve) that future when JMS message arrives, and this is driven by an event. In this case you can simply create CompletableFuture, return it to your client and whenever you think your results are available, simply complete() the future and unlock all clients waiting on that future.

```
public CompletableFuture<String> ask() {
    final CompletableFuture<String> future = new CompletableFuture<>();
    //...
    return future;
}
```

Notice that this future is not associated wtih any Callable<String>, no thread pool, no asynchronous job. If now the client code calls ask().get() it will block forever. If it registers some completion callbacks, they will never fire. So what's the point? Now you can say:

```
future.complete("42")
```

...and at this very moment all clients blocked on Future.get() will get the result string. Also completion callbacks will fire immediately. This comes quite handy when you want to represent a task in the future, but not necessarily computational task running on some thread of execution.

CompletableFuture.complete() can only be called once, subsequent invocations are ignored. But there is a back-door called CompletableFuture.obtrudeValue(...) which overrides previous value of the Future with new one. Use with caution.

Sometimes you want to signal failure. As you know Future objects can handle either wrapped result or exception. If you want to pass some exception further, there is CompletableFuture.completeExceptionally(ex) (and obtrudeException(ex) evil brother that overrides the previous exception). completeExceptionally() also unlock all waiting clients, but this time throwing an exception from get().

Speaking of get(), there is also CompletableFuture.join() method with some subtle changes in error handling. But in general they are the same. 

And finally there is also CompletableFuture.getNow(valueIfAbsent) method that doesn't block but if the Future is not completed yet, returns default value. Useful when building robust systems where we don't want to wait too much.

Last static utility method is completedFuture(value) that returns already completed Future object. Might be useful for testing or when writing some adapter layer.

**Creating and obtaining CompletableFuture**

We can wrap existing task with CompletableFuture using the following family of factory methods:

```
static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier);
static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier, Executor executor);
static CompletableFuture<Void> runAsync(Runnable runnable);
static CompletableFuture<Void> runAsync(Runnable runnable, Executor executor);
```

Methods that do not take an Executor as an argument but end with ...Async will use ForkJoinPool.commonPool() (global, general purpose pool introduces in JDK 8). This applies to most methods in CompletableFuture class. 

runAsync() is simple to understand, notice that it takes Runnable, therefore it returns CompletableFuture<Void> as Runnable doesn't return anything. 

If you need to process something asynchronously and return result, use Supplier<U>:

```
final CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
    @Override
    public String get() {
        //...long running...
        return "42";
    }
}, executor);
```

But hey, we have lambdas in Java 8!

```
final CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
    //...long running...
    return "42";
}, executor);
```

or even:

```
final CompletableFuture<String> future = 
    CompletableFuture.supplyAsync(() -> longRunningTask(params), executor);
```

**Transforming and acting on one CompletableFuture (thenApply)**

We don't have to wait and block until it's ready. We can simply say: run this function on a result, when it arrives.

Moreover, we can stack such functions, combine multiple futures together, etc. For example if we have a function from String to Integer we can turn CompletableFuture<String> to CompletableFuture<Integer> without unwrapping it. This is achieved with thenApply() family of methods:

```
<U> CompletableFuture<U> thenApply(Function<? super T,? extends U> fn);
<U> CompletableFuture<U> thenApplyAsync(Function<? super T,? extends U> fn);
<U> CompletableFuture<U> thenApplyAsync(Function<? super T,? extends U> fn, Executor executor);
```

first method will apply function within the same thread in which the future completed while the remaining two will apply it asynchronously in different thread pool.

Let's see how thenApply() works:

```
CompletableFuture<String> f1 = //...
CompletableFuture<Integer> f2 = f1.thenApply(Integer::parseInt);
CompletableFuture<Double> f3 = f2.thenApply(r -> r * r * Math.PI);
```

Or in one statement:

```
CompletableFuture<Double> f3 = 
    f1.thenApply(Integer::parseInt).thenApply(r -> r * r * Math.PI);
```

You see a sequence of transformations here. From String to Integer and then to Double. 

But what's most important, these transformations are neither executed immediately nor blocking. 

They are simply remembered and when original f1 completes they are executed for you.

If some of the transformations are time-consuming, you can supply your own Executor to run them asynchronously.

**Running code on completion (thenAccept/thenRun)**

```
CompletableFuture<Void> thenAccept(Consumer<? super T> block);
CompletableFuture<Void> thenRun(Runnable action);
```

These two methods are typical "final" stages in future pipeline.

They allow you to consume future value when it's ready. 

While thenAccept() provides the final value, thenRun executes Runnable which doesn't even have access to computed value. 

Example:

```
future.thenAcceptAsync(dbl -> log.debug("Result: {}", dbl), executor);
log.debug("Continuing");
```

...Async variants are available as well for both methods, with implicit and explicit executor. 

I can't emphasize this enough: thenAccept()/thenRun() methods do not block (even without explicit executor). Treat them like an event listener/handler that you attach to a future and that will execute some time in the future. 

"Continuing" message will appear immediately, even if future is not even close to completion.

**Error handling of single CompletableFuture**

So far we only talked about result of computation. But what about exceptions? Can we handle them asynchronously as well? Sure!

```
CompletableFuture<String> safe = 
    future.exceptionally(ex -> "We have a problem: " + ex.getMessage());
```

exceptionally() takes a function that will be invoked when original future throws an exception.

We then have an opportunity to recover by transforming this exception into some value compatible with Future's type. 

Further transformations of safe will no longer yield an exception but instead a String returned from supplied function.

A more flexible approach is handle() that takes a function receiving either correct result or exception:

```
CompletableFuture<Integer> safe = future.handle((ok, ex) -> {
    if (ok != null) {
        return Integer.parseInt(ok);
    } else {
        log.warn("Problem", ex);
        return -1;
    }
});
```

handle() is called always, with either result or exception argument being not-null. This is a one-stop catch-all strategy.

**Combining two CompletableFuture together**

**Combining (chaining) two futures (thenCompose())**

**Transforming values of two futures (thenCombine())**

**Waiting for both CompletableFutures to complete**

**Waiting for first CompletableFuture to complete**

**Transforming first completed**

**Combining multiple CompletableFuture together**




**From:**
  https://nurkiewicz.com/2013/05/java-8-definitive-guide-to.html
