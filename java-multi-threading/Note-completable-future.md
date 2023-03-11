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

**Transforming and acting on one CompletableFuture (thenApply)**

**Running code on completion (thenAccept/thenRun)**

**Error handling of single CompletableFuture**

**Combining two CompletableFuture together**

**Combining (chaining) two futures (thenCompose())**

**Transforming values of two futures (thenCombine())**

**Waiting for both CompletableFutures to complete**

**Waiting for first CompletableFuture to complete**

**Transforming first completed**

**Combining multiple CompletableFuture together**




**From:**
  https://nurkiewicz.com/2013/05/java-8-definitive-guide-to.html
