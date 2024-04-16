We should not share data between objects. instead, we should create _new classes_ that help us share functionality.

If you put too much meaning in some words and reuse them frequently, the text becomes unreadable. here is an example:

```
My cat likes to eat fish and drink milk.
```

Here is another example, which use a bit less words:

```
My thing likes to eat that thing and drink another thing.
```

We are overusing the word _thing_, putting too much meaning into it. the same happens with classes, which are too big and too powerful.

Instead of :

```java

String body = new HttpRequest()
	.method("POST")
	.fetch();
```

Or

```java

String body = new HttpRequest()
	.method(HttpMethods.POST)
	.fetch();
```

Would be much better to create a number of simple classes that would represent those methods: 

```java
String body = new PostRequest(new HttpRequest()).fetch();
```
 
Now, _PostRequest_ knows how to configure _HttpRequest_ so it makes a POST request instead of a default GET one.