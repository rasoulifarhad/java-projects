### Guava

what Future<T> is - a place-holder for something, that you will get in the future.(It's like keys to a car that was not yet manufactured.)

How do you actually obtain an instance of Future<T> in your application? 

Two most common sources are thread pools and asynchronous methods (backed by thread pools for you).


##### ListenableFuture

ListenableFuture in Guava is an attempt to define consistent API for Future objects to register completion callbacks.

With the ability to add callback when Future completes, we can asynchronously and effectively respond to incoming events. 

If your application is highly concurrent with lots of future objects, use ListenableFuture whenever you can.

 ListenableFuture extends Future interface by adding simple: 
 
  > void addListener(Runnable listener, Executor executor)
  
We can register Runnable to be executed immediately when future in question completes. 

 Executor (ExecutorService extends it) will be used to execute listener - (long-running listeners do not occupy worker threads)

##### SettableFuture

SettableFuture adds possibility to set value of the future (resolve it) from arbitrary thread and context.
