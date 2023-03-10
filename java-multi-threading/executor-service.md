## Executor Service

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
From https://baptiste-wicht.com/posts/2010/09/java-concurrency-part-7-executors-and-thread-pools.html
