### AtomicStampedReference and the A-B-A Problem

The AtomicStampedReference is designed to solve the A-B-A problem. The A-B-A problem is when a reference is changed from pointing to A, then to B and then back to A.

When using compare-and-swap operations to change a reference atomically, and making sure that only one thread can change the reference from an old reference to a new, detecting the A-B-A situation is impossible.

The A-B-A problem can occur in non-blocking algorithms. Non-blocking algorithms often use a reference to an ongoing modification to the guarded data structure, to signal to other threads that a modification is currently ongoing. If thread 1 sees that there is no ongoing modification (reference points to null), another thread may submit a modification (reference is now non-null), complete the modification and swap the reference back to null without thread 1 detecting it. 

By using an AtomicStampedReference instead of an AtomicReference it is possible to detect the A-B-A situation. Thread 1 can copy the reference and stamp out of the AtomicStampedReference atomically using get(). If another thread changes the reference from A to B and then back to A, then the stamp will have changed (provided threads update the stamp sensibly - e.g increment it).

