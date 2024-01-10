## Note

**Class constant pool**

Each class has its own constant pool - a list of constant values that can be reused if they occur several times in the source code.

It includes common strings, numbers, method names, etc.

If :

**Java code**
  
  ```
  String one = "xyz";
  String two = "xyz";
  ```

**Class constant pool**

  ```
  const #2 = String   #38;  //  xyz
  // ...
  const #38 = Asciz  xyz;
  ```
  
The important thing to note is the distinction between String constant object (#2) and Unicode encoded text "abc" (#38) that the string points to.

**Byte code**

  ```
  ldc #2;     //String xyz
  astore_1    //one
  ldc #2;     //String xyz
  astore_2    //two
  ``` 
  
Note that both one and two references are assigned with the same #2 constant pointing to "abc" string.

**Output**

  ```
  [main] INFO com.farhad.example.string.UtilsTest - one.value: 22069592
  [main] INFO com.farhad.example.string.UtilsTest - two.value: 22069592
  [main] INFO com.farhad.example.string.UtilsTest - one: 897074030
  [main] INFO com.farhad.example.string.UtilsTest - two: 897074030
  ```
  
Which means that not only both objects point to the same char[] (the same text underneath) so equals() test will pass.

But even more, one and two are the exact same references! So one == two is true as well. 

Obviously if one and two point to the same object then one.value and two.value must be equal.

If :

**Java code**
  
  ```
  String one = "xyz";
  String two = new String("xyz");
  ```

**Class constant pool**

  ```
  const #2 = String   #38;  //  xyz
  // ...
  const #38 = Asciz  xyz;
  ```
  
**Byte code**

  ```
  ldc #2;     //String xyz
  astore_1    //one
  
  new #3; //class java/lang/String
  dup
  ldc #2; //String xyz
  invokespecial   #4; //Method java/lang/String."<init>":(Ljava/lang/String;)V
  astore_2    //two
  ``` 
  
The first object is created the same way as above, no surprise.It just takes a constant reference to already created String (#2) from the constant pool.

However the second object is created via normal constructor call. But! The first String is passed as an argument. This can be decompiled to:

  ```
  String two = new String(one);
  ```

**Output**

  ```
  [main] INFO com.farhad.example.string.UtilsTest - one.value: 22069592
  [main] INFO com.farhad.example.string.UtilsTest - two.value: 22069592
  [main] INFO com.farhad.example.string.UtilsTest - one: 897074030
  [main] INFO com.farhad.example.string.UtilsTest - two: 1885996206
  ```
  
The second pair, representing references to String object is understandable - we created two String objects - one was created for us in the constant pool and the second one was created manually for two. 

But why, on earth the first pair suggests that both String objects point to the same char[] value array?!

It becomes clear when you look at how String(String) constructor works.

When you are creating new String object based on existing one, it reuses char[] value. Strings are immutable, there is no need to copy data structure that is known to be never modified. Moreover, since new String(someString) creates an exact copy of existing string and strings are immutable, there is clearly no reason for the two to exist at the same time.

  ```
  public String(String original) {
    this.offset = original.offset;
    this.count = original.count;
    this.value = original.value;
  }
  ```
  
Even if you have two String objects, they might still point to the same contents. 


If : (Runtime modification and intern())

**Java code**
  
  ```
  String one = "xyz";
  String two = "?xyz".substring(1); //also two = "xyz"
  ```

**Class constant pool**

We ended up with two constant strings pointing to two different constant texts:

  ```
  const #2 = String   #44;    //  xyz
  const #3 = String   #45;    //  ?xyz
  const #44 = Asciz   xyz;
  const #45 = Asciz   ?xyz;
  ```
  
**Byte code**

  ```
  ldc #2; //String xyz
  astore_1    //one

  ldc #3; //String ?xyz
  iconst_1
  invokevirtual   #4; //Method String.substring:(I)Ljava/lang/String;
  astore_2    //two
  ``` 
  
The fist string is constructed as usual. The second is created by first loading the constant "?abc" string and then calling substring(1) on it.

**Output**

  ```
  [main] INFO com.farhad.example.string.UtilsTest - one.value: 22069592
  [main] INFO com.farhad.example.string.UtilsTest - two.value: 897074030
  [main] INFO com.farhad.example.string.UtilsTest - one: 1885996206
  [main] INFO com.farhad.example.string.UtilsTest - two: 1859039536
  ```
  
Well, the texts aren't really different, equals() method will still yield true. We have two unnecessary copies of the same text.

Now we should run two exercises. First, try running code below before printing hash codes.

  ```
  two = two.intern();
  ```

The second exercise is slightly different, check out this:

  ```
  String one = "xyz";
  String two = "xyz".substring(1);
  ```

**first**:

Not only both one and two point to the same text, but they are the same reference!
This means both one.equals(two) and one == two tests will pass. Also we saved some memory because "abc" text appears only once in memory (the second copy will be garbage collected).

  ```
  [main] INFO com.farhad.example.string.UtilsTest - one.value: 22069592
  [main] INFO com.farhad.example.string.UtilsTest - two.value: 22069592
  [main] INFO com.farhad.example.string.UtilsTest - one: 897074030
  [main] INFO com.farhad.example.string.UtilsTest - two: 897074030
  ```

**second**:

Obviously one and two are two different objects, pointing to two different texts. But how come the output suggests that they both point to the same char[] array?!?

  ```
  [main] INFO com.farhad.example.string.UtilsTest - one.value: 22069592
  [main] INFO com.farhad.example.string.UtilsTest - two.value: 897074030
  [main] INFO com.farhad.example.string.UtilsTest - one: 1885996206
  [main] INFO com.farhad.example.string.UtilsTest - two: 1859039536
  ```

**recap**

  * String object itself is rather cheap. It's the text it points to that consumes most of the memory
  * String is just a thin wrapper around char[] to preserve immutability
  * new String("abc") isn't really that expensive as the internal text representation is reused. But still avoid such construct.
  * When String is concatenated from constant values known at compile time, concatenation is done by the compiler, not by the JVM
  * substring() is tricky, but most importantly, it is very cheap, both in terms of used memory and run time (constant in both cases)
  
**The constant pool**

The constant pool table is where most of the literal constant values are stored. This includes values such as numbers of all sorts, strings, identifier names, references to classes and methods, and type descriptors.

All indexes, or references, to specific constants in the constant pool table are given by 16-bit (type u2) numbers, where index value 1 refers to the first constant in the table (index value 0 is invalid).

  ```
  u1: an unsigned 8-bit integer
  u2: an unsigned 16-bit integer in big-endian byte order
  u4: an unsigned 32-bit integer in big-endian byte order
  table: an array of variable-length items of some type. The number of items in the table is identified by a preceding count number (the count is a u2), but the size in bytes of the table can only be determined by examining each of its items.
  ```  



See https://blog.jooq.org/the-dangers-of-correlating-subtype-polymorphism-with-generic-polymorphism/
See https://levelup.gitconnected.com/java-generics-advanced-cases-d05db19b47d5
See https://micsymposium.org/mics_2009_proceedings/mics2009_submission_56.pdf
See https://unlinkedlist.org/2023/04/05/java-recursive-generics/
See https://medium.com/@hazraarka072/fluent-builder-and-powering-it-up-with-recursive-generics-in-java-483005a85fcd
See https://vyazelenko.com/2012/03/02/recursive-generics-to-the-rescue/
See https://levelup.gitconnected.com/java-generics-advanced-cases-d05db19b47d5  
See https://www.sitepoint.com/self-types-with-javas-generics/
See https://dzone.com/articles/introduction-generics-java-%E2%80%93-0?source=post_page-----483005a85fcd--------------------------------