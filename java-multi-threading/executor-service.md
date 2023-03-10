## Executor Service

**Thread and Runnable Definitions**

Thread is a class that starts new independent activity and performs instructions supplied by Runnable.

  ``` 
  - Thread is one who start instructions
  - Runable is just a set of instructions
  ```
  
**Execute New Thread**

Thread is an entity that is attached to the OS so this is why it's a heavy class.

Runnable is just a set of instructions — so this is why it's lightweight.

  ```
  ( new Thread() ).run();   // run in current thread
  ( new Thread() ).start(); // run in new thread
  ```

**Reuse Thread**

Many runnables (tasks) run inside one single thread:

  ```
  List<Runnable> tasks = new ArrayList<>();
  ( new Thread( () -> {
         for (Runnable task : tasks) {
            task.run();
         }            
  })).start();

  ```
**Stop Thread**

Don not use depricated methods to stop thread.(stop/suspend/resume)

You have to create interruption design by using interrupt() or isInterrupted() 

  ```
  ( new Thread( () -> {
        while ( true ) {
            // process of logic
            if( Thread.currentThread().isInterrupted() ) {
                // handle exiting
                break;
            }
        }   
  })).start();
  ```
  
**Thread Daemon**

Thread can be a daemon.

Daemon threads are interrupted instantly even the final part won't be executed. So such threads can be attached to resources. Otherwise, they can be the reason for resource or/and memory leaks.

  ```
  Thread thread = ( new Thread( () -> {
                        try {
                           // working with resource  
                        } finally{
                           // resource.close();
                           // might won't work because finally if deamon been interrupted  
                        }
                }));
  thread.setDaemon(true);
  thread.start();
  ```

**Thread Pool**

As long as the Thread instance is heavy it makes sense to reuse the same Thread using ThreadPool class.

You can use different ThreadPool implementations depending on your thread.

  * Fixed Thread Pool
  * Cached Thread Pool
  * ..

In order to use the best Thread Pool for your application you need to understand next things:

  * If your thread does a lot of computation like video rendering, encryption, etc., then it eats processes that run that thread.
  * If your thread runs not related to CPU activity like networking calls, memory calls, etc., then it won't consume the CPU that runs its thread.

Relying on this knowledge you might make the next conclusions:

  * Having high CPU consumable tasks don't allocate more threads than CPU cores
  * Having low CPU consumable tasks you can have a number of threads more than CPU cores (but proportion depends on the specific situation).
  
**Executor Service**

Thread can execute instructions inside the current running thread by using Run() method.

To run instructions in a new activity, Thread provides Start() method.

A thread pool is represented by an instance of the class ExecutorService.

With an ExecutorService, you can submit task that will be completed in the future.

Here are the type of thread pools you can create with the Executors class :

  * Single Thread Executor : A thread pool with only one thread. So all the submitted tasks will be executed sequentially. Method : Executors.newSingleThreadExecutor()
  
  * Cached Thread Pool : A thread pool that creates as many threads it needs to execute the task in parrallel. The old available threads will be reused for the new tasks. If a thread is not used during 60 seconds, it will be terminated and removed from the pool. Method : Executors.newCachedThreadPool()
  
  * Fixed Thread Pool : A thread pool with a fixed number of threads. If a thread is not available for the task, the task is put in queue waiting for an other task to ends. Method : Executors.newFixedThreadPool()
  
  * Scheduled Thread Pool : A thread pool made to schedule future task. Method : Executors.newScheduledThreadPool()

  * Single Thread Scheduled Pool : A thread pool with only one thread to schedule future task. Method : Executors.newSingleThreadScheduledExecutor()

Once you have a thread pool, 

  ```
  You can submit task to it using the different submit methods.

  You can submit a Runnable or a Callable to the thread pool.

  The method return a Future representing the future state of the task. 

  If you submitted a Runnable, the Future object return null once the task finished.
  
  You must shutdown the thread pool in order to terminate all the threads of the pool.
  
  If you don’t do that, the JVM risks to not shutdown because there is still unterminated threads.
  
  You can also force the shutdown of the pool using shutdownNow. With that the currently running tasks will be interrupted and the tasks not started will not be started at all.
  ```
A CompletionService is a service that make easier to wait for result of submitted task to an executor. 

The implementation is ExecutorCompletionService who’s based on an ExecutorService to work.

  ```
  public void submitCallableTasksWithCompletionService(CallableTask... tasks) {

    ExecutorService executorService = null;
    CompletionService<CalcResult> taskCompletionService = null;

    try {

      executorService = Executors.newFixedThreadPool(tasks.length);
      taskCompletionService = new  ExecutorCompletionService<>(executorService);

      for (CallableTask callableTask : tasks) {

          taskCompletionService.submit(callableTask);
        
      }
      int tasksSubmited = tasks.length;
      for (int tasksHandled = 0; tasksHandled < tasksSubmited; tasksHandled++) {
        
          log.info("Try to take from Completion Service");

          // blocks till atleast one task is completed and results availble
          Future<CalcResult> calcResultFuture = taskCompletionService.take();

          log.info("result for a task available. trying  to get it");

          CalcResult calcResult = calcResultFuture.get();
          log.info("Task {} Complated. Result: {}", tasksHandled, calcResult);
      }
    } catch (InterruptedException e) {
       log.error("Interrupted Exception ");
       e.printStackTrace();
    } catch (ExecutionException e) {
       log.error("get() threw Exception ");
       e.printStackTrace();
    } finally {
       executorService.shutdown();
    }
  }
  ```
  
People use the Future returned by submit to process results and this is NOT correct usage. 
 
  https://www.javaspecialists.eu/archive/Issue214-CountingCompletionService.html
  
  See also
   * FutureTask
   * RunnableFuture

From https://baptiste-wicht.com/posts/2010/09/java-concurrency-part-7-executors-and-thread-pools.html
