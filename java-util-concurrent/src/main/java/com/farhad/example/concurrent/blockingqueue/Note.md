### Java BlockingQueue

Jakob Jenkov: 

The Java BlockingQueue interface, java.util.concurrent.BlockingQueue, represents a queue which is thread safe to put elements into, and take elements out of from. In other words, multiple threads can be inserting and taking elements concurrently from a Java BlockingQueue, without any concurrency issues arising.

The term blocking queue comes from the fact that the Java BlockingQueue is capable of blocking the threads that try to insert or take elements from the queue. Whether or not the calling thread is blocked depends on what methods you call on the BlockingQueue.  

A BlockingQueue is typically used to have one thread produce objects, which another thread consumes.

![blocking-queue](images/blocking-queue.png)

 If the consuming thread tries to take an object out of an empty queue, the consuming thread is blocked until a producing thread puts an object into the queue.

#### BlockingQueue Implementations

- ArrayBlockingQueue
- DelayQueue
- LinkedBlockingQueue
- LinkedBlockingDeque
- LinkedTransferQueue
- PriorityBlockingQueue
- SynchronousQueue

#### BlockingQueue Methods

The Java BlockingQueue interface has 4 different sets of methods for inserting, removing and examining the elements in the queue. Each set of methods behaves differently in case the requested operation cannot be carried out immediately.

The 4 different sets of behaviour means this:

1. Throws Exception: If the attempted operation is not possible immediately, an exception is thrown. add(o), remove(o), element()

2. Special Value: If the attempted operation is not possible immediately, a special value is returned (often true / false). offer(O), poll(), peek()

3. Blocks: If the attempted operation is not possible immedidately, the method call blocks until it is. put(o), take()

4. Times Out: If the attempted operation is not possible immedidately, the method call blocks until it is, but waits no longer than the given timeout. Returns a special value telling whether the operation succeeded or not (typically true / false). offer(o, timeout, timeunit), pill(o, timeout, timeunit)

It is not possible to insert null into a BlockingQueue.


