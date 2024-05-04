
Consider the set of classes needed to manage orders for a small art photography business. The business sells prints, which can be made in various sizes, on matte or glossy paper, with or without a frame, without a mat or with one or more mats that come in many colors. It also sells prints digitally through a variety of stock photo agencies.

Your ﬁrst thought might be to use inheritance to implement this data model. However, trying to make a different class for every combination of paper ﬁnish, paper size, with and without a mat, and with and without a frame would result in a true explosion of classes. And it would all fall apart as soon as market conditions changed and the business tried to add another variable. The opposite approach—trying to make one class to handle all the combinations—would result in a tangled mess of if statements that are fragile and difﬁcult to understand and maintain.

One of the best solutions to this problem is the Decorator pattern, which
allows you to add functionality to an existing component from outside the
class. To do this, you create a class called Decorator (typically
abstract), which needs to implement the same interface as the original
Component (the class to which we’re adding functionality); that is, the
Decorator needs to be able to substitute for the original, using its
interface or class deﬁnition as appropriate. The Decorator will hold an
instance of the Component class, which it is also extending. The
Decorator will, thus, be in both a has-a and an is-a relationship with the
Component .

```java
public abstract class Decorator extends Component {
  protected Component target;
  . . .
}
```


As a result of this inheritance, the Decorator or its subclasses can be  used where the original was used, and it will directly delegate business methods to the original. You can then make subclasses from this Decorator . The subclasses will usually add “before” and/or “after” functionality to some or all of the methods that they delegate to the real target; this is, in fact, their raison d’être.