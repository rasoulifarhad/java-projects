**Life cycle of a thread**

                                                ┌─────────┐
                                                │  Start  │
                                                └────┬────┘
                                                     │         
                                                   start           
                                                     │  
                                                     V      
                                                ┌──────────┐          
                   ┌──────lock acquired────────>│ Runnable │<─────────notify/resume────┐
                   │                            └────┬─────┘                           │
                   │                                 │                                 │
                   │                             scheduled                             │
                   │                                 │                                 │
                   │                                 V                                 │ 
              ┌────┴────┐                       ┌─────────┐                       ┌────┴────┐
              │ Blocked │<────wait for lock─────┤ Running ├───────sleep/wait─────>│ Waiting │
              └─────────┘                       └────┬────┘                       └─────────┘
                                                     │        
                                                  stop/exit            
                                                     │        
                                                     V        
                                               ┌────────────┐
                                               │ Terminated │
                                               └────────────┘
                                               
As soon as we create a new thread, it’s in the NEW state. It remains in this state until the program starts the thread using the start() method.

Calling the start() method on a thread puts it in the RUNNABLE state. Threads in this state are either running or ready to run.

When a thread is waiting for a monitor lock and is trying to access code that is locked by some other thread, it enters the BLOCKED state.

A thread can be put in the WAITING state by various events, such as a call to the wait() method. In this state, a thread is waiting for a signal from another thread.

When a thread either finishes execution or terminates abnormally, it'll wind up in the TERMINATED state. 

**Threads can be interrupted, and when a thread is interrupted, it will throw InterruptedException.**

**InterruptedException?**

An InterruptedException is thrown when a thread is interrupted while it's waiting, sleeping, or otherwise occupied. In other words, some code has called the interrupt() method on our thread. It's a checked exception, and many blocking operations in Java can throw it.

**Interrupts**

**The purpose of the interrupt system is to provide a well-defined framework for allowing threads to interrupt tasks (potentially time-consuming ones) in other threads.** A good way to think about interruption is that it doesn't actually interrupt a running thread — it just requests that the thread interrupt itself at the next convenient opportunity.

**Blocking and Interruptible Methods**

Threads may block for several reasons: waiting to wake up from a Thread.sleep(), waiting to acquire a lock, waiting for I/O completion, or waiting for the result of a computation in another thread, among others.

**The InterruptedException is usually thrown by all blocking methods so that it can be handled and the corrective action can be performed.** There are several methods in Java that throw InterruptedException. These include Thread.sleep(), Thread.join(), the wait() method of the Object class, and put() and take() methods of BlockingQueue, to name a few.

**Interruption Methods in Threads**

Let's have a quick look at some key methods of the Thread class for dealing with interrupts:
  ```
  public void interrupt() { ... }
  public boolean isInterrupted() { ... }
  public static boolean interrupted() { ... }
  ```

**Thread provides the interrupt() method for interrupting a thread, and to query whether a thread has been interrupted, we can use the isInterrupted() method.**  Occasionally, we may wish to test whether the current thread has been interrupted and if so, to immediately throw this exception. Here, we can use the interrupted() method:

  ```
  if (Thread.interrupted()) {
     throw new InterruptedException();
  }
  ```

**The Interrupt Status Flag**

The interrupt mechanism is implemented using a flag known as the interrupt status. **Each thread has a boolean property that represents its interrupted status. Invoking Thread.interrupt() sets this flag. When a thread checks for an interrupt by invoking the static method Thread.interrupted(), the interrupt status is cleared.**

To respond to interrupt requests, we must handle InterruptedException. We'll see how to do just that in the next section.
                                               
