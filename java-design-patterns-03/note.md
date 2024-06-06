See https://timepasstechies.com/category/programming/design-patterns/
See https://home.csulb.edu/~pnguyen/cecs277/lecnotes/Command%20Pattern%201.pdf
See https://www.opencodez.com/java/command-design-pattern.htm
See https://ima.udg.edu/~sellares/EINF-ES1/CommandToni.pdf
See https://github.com/PacktPublishing/Practical-Design-Patterns-for-Java-Developers/tree/main
See https://github.com/PacktPublishing/Java-Coding-Problems/tree/master
See https://www.jot.fm/issues/issue_2006_03/article3/
See https://github.com/cs4125/jj
See https://github.com/shaswat-indian/OOADP-Lab
See https://blog.stackademic.com/design-patterns-bridge-ce8af9bc0901
See https://stacktraceguru.com/bridge-design-pattern/
See https://dotnettutorials.net/lesson/bridge-design-pattern-real-time-example/	
See https://medium.com/@oppahansi
See https://medium.com/@oppahansi/code-smells-left-overs-7b51f0f7ae83
See https://medium.com/@oppahansi/code-smells-couplers-db180c1bb925
See https://medium.com/@oppahansi/code-smells-bloaters-ff433cec263b
See https://medium.com/@oppahansi/refactoring-techniques-in-software-development-part-1-c2e59f744d2c
See https://www.martinfowler.com/bliki/CallSuper.html
See https://www.martinfowler.com/tags/bad%20things.html
See https://medium.com/@jonblankenship/using-the-specification-pattern-to-build-a-data-driven-rules-engine-b3db95189ff8
See https://github.com/jonblankenship/stock-alerts/tree/master

See https://gameprogrammingpatterns.com/prototype.html

### Command 

The command design pattern is one of the behavioral design patterns. This design pattern can be considered for use when there is clear segregation between requester and executor of an action or a command.

In the command design pattern, all information needed to perform an action are encapsulated in an object. 

Following terms always comes with command pattern i.e. Command, Concrete Command, Receiver, Invoker, and Client.

**Command**

This declares a common interface that will be implemented by all Concrete Commands. At a minimum, it must declare one method to execute the actual action.

**Concrete Command**

This class performs actual operation or command. It extends the Command interface and implements the appropriate method for execution on a receiver.

**Client**

The client has the responsibility to create Concrete Command. The command then passed on to Invoker.

**Invoker**

As the name suggests, these are only to invoke actual execute operation or action. These classes get a pre-created concrete commands object from the client.

**Receiver**

These hold the business logic to carry out a command or operation.

The command design pattern can be explained perfectly with a restaurant example. Where the customer places an order/command with the waiter. Then waiter runs it through his manager and then its passed on to cook for execution.  When food is ready, the command to serve food to the customer is carried out by the waiter.
