## Queue

See [What Is a Queue?](https://dzone.com/articles/what-is-a-queue)

> Queue follows the **FIFO** principle (**First In, First Out**)

<br/>

> ***In a queue data structure, we remove the least recently inserted item.***

<br/>

> Four basic operations:  

>> `enqueue()`: add item to queue  

>> `dequeue()`: remove the least recently inserted item from queue   

>> `front()`: returns item at front of queue  

>> `rear()`: return item at the end of queue  

<br/>

> Helper methods  

>> `size()`  

>> `isFull()`  

>> `isEmpty()`  

<br/>

> Internal structure  

>> **front**: position of front element  

>> **rear**: position of rare element

>> **size**: current size of queue

>> **array**: inner array, containing items in queue


<br/>

> **Linear queue**

<br/>

> **Ring Buffer** and **Circular Queue**  

>>  If either `front` or `rear` reach the last position of the **array**, we’ll reconnect it back to the **start of the array**.

