### AtomicInteger

The AtomicInteger class provides you with a int variable which can be read and written atomically, and which also contains advanced atomic operations like compareAndSet(). The AtomicInteger class is located in the java.util.concurrent.atomic package, so the full class name is java.util.concurrent.atomic.AtomicInteger . 

> AtomicInteger atomicInteger = new AtomicInteger();
> or
> AtomicInteger atomicInteger = new AtomicInteger(123);
> 
> int theValue = atomicInteger.get();
> atomicInteger.set(234);
 
> AtomicInteger atomicInteger = new AtomicInteger(234);
> int expectedValue = 234;
> int newValue      = 123;
> atomicInteger.compareAndSet(expectedValue, newValue);

> AtomicInteger atomicInteger = new AtomicInteger();
> # Adding to the AtomicInteger Value: addAndGet / getAndAdd / getAndIncrement / incrementAndGet
> System.out.println(atomicInteger.getAndAdd(10));
> System.out.println(atomicInteger.addAndGet(10));

> AtomicInteger atomicInteger = new AtomicInteger();
> # Subtracting From the AtomicInteger Value: decrementAndGet / getAndDecrement
> System.out.println(atomicInteger.getAndDecrement(10));
> System.out.println(atomicInteger.decrementAndGet(10));

#### AtomicStampedReference and the A-B-A Problem

The AtomicStampedReference is designed to solve the A-B-A problem. The A-B-A problem is when a reference is changed from pointing to A, then to B and then back to A.

When using compare-and-swap operations to change a reference atomically, and making sure that only one thread can change the reference from an old reference to a new, detecting the A-B-A situation is impossible.

The A-B-A problem can occur in non-blocking algorithms. Non-blocking algorithms often use a reference to an ongoing modification to the guarded data structure, to signal to other threads that a modification is currently ongoing. If thread 1 sees that there is no ongoing modification (reference points to null), another thread may submit a modification (reference is now non-null), complete the modification and swap the reference back to null without thread 1 detecting it. 

By using an AtomicStampedReference instead of an AtomicReference it is possible to detect the A-B-A situation. Thread 1 can copy the reference and stamp out of the AtomicStampedReference atomically using get(). If another thread changes the reference from A to B and then back to A, then the stamp will have changed (provided threads update the stamp sensibly - e.g increment it).

