## Java class file

A Java class file is a file (with the .class filename extension) containing Java bytecode that can be executed on the Java Virtual Machine (JVM).

A Java class file is usually produced by a Java compiler from Java programming language source files (.java files) containing Java classes (alternatively, other JVM languages can also be used to create class files). If a source file has more than one class, each class is compiled into a separate class file.

**File layout and structure**

**Sections**

There are 10 basic sections to the Java class file structure:

  * Magic Number: 0xCAFEBABE
  * Version of Class File Format: the minor and major versions of the class file
  * Constant Pool: Pool of constants for the class
  * Access Flags: for example whether the class is abstract, static, etc.
  * This Class: The name of the current class
  * Super Class: The name of the super class
  * Interfaces: Any interfaces in the class
  * Fields: Any fields in the class
  * Methods: Any methods in the class
  * Attributes: Any attributes of the class (for example the name of the sourcefile, etc.)

**The constant pool**

The constant pool table is where most of the literal constant values are stored. This includes values such as numbers of all sorts, strings, identifier names, references to classes and methods, and type descriptors.

All indexes, or references, to specific constants in the constant pool table are given by 16-bit (type u2) numbers, where index value 1 refers to the first constant in the table (index value 0 is invalid).

  ```
  u1: an unsigned 8-bit integer
  u2: an unsigned 16-bit integer in big-endian byte order
  u4: an unsigned 32-bit integer in big-endian byte order
  table: an array of variable-length items of some type. The number of items in the table is identified by a preceding count number (the count is a u2), but the size in bytes of the table can only be determined by examining each of its items.
  ```  

