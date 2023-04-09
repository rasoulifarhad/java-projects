### SynchronousQueue

The SynchronousQueue is a queue that can be used to exchange a single element with another thread. A thread inserting an element into the queue is blocked until another thread takes that element from the queue. Likewise, if a thread tries to take an element and no element is currently present, that thread is blocked until a thread insert an element into the queue.

