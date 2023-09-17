See https://www.linkedin.com/pulse/asynchronous-programming-java-completablefuture-aliaksandr-liakh

See https://dev.to/sunilkumarl/merge-results-of-parallel-service-requests-using-completablefuture-40no

See https://dzone.com/articles/20-examples-of-using-javas-completablefuture

See https://www.codepedia.org/ama/how-to-make-parallel-calls-in-java-with-completablefuture-example

See https://reflectoring.io/java-completablefuture/

See https://theboreddev.com/parallel-api-calls-with-completablefuture/

See https://medium.com/swlh/combining-multiple-api-calls-with-completablefuture-1d9d27e03bec

See https://developer.confluent.io/tutorials/cogrouping-streams/confluent.html

See https://jet-start.sh/docs/how-tos/custom-aggregate-operation

See https://dzone.com/articles/grouping-and-aggregations-with-java-streams

See https://github.com/aliakh/demo-java-completablefuture/tree/master

Example:

First, we need to call two long-running methods that return a product price in the EUR and the EUR/USD exchange rate. Then, we need to calculate the net product price from the results of these methods. Then, we need to call the third long-running method that takes the net product price and returns the tax amount. Finally, we need to calculate the gross product price from the net product price and the tax amount.

Implementation of this workflow is divided into the following tasks:

1. to get the product price in the EUR (a slow task)
2. to get the EUR/USD exchange rate (a slow task)
3. to calculate the net product price (a fast task, depends on tasks 1, 2)
4. to get the tax amount (a slow task, depends on tasks 3)
5. to calculate the gross product price (a fast task, depends on tasks 3, 4)

> Note about tasks:

<br/>


>> Some of them are fast (they should be executed synchronously), 

<br/>

>> some of them are slow (they should be executed asynchronously).

<br/>

>> Some of them are independent (they can be executed in parallel),

<br/>

>> some of them depend on the results of previous tasks (they have to be executed sequentially).

<br/>

