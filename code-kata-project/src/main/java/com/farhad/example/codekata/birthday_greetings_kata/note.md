## Problem: write a program that

- Loads a set of employee records from a flat file
- Sends a greetings email to all employees whose birthday is today

The flat file is a sequence of records, separated by newlines; this are the first few lines:

```
last_name, first_name, date_of_birth, email
Doe, John, 1982/10/08, john.doe@foobar.com
Ann, Mary, 1975/09/11, mary.ann@foobar.com
```

The greetings email contains the following text:


```
Subject: Happy birthday!

Happy birthday, dear John!
```

The program should be invoked by a main program like this one:

```
public static void main(String[] args) {
    ...
    BirthdayService birthdayService = new BirthdayService(
        employeeRepository, emailService);
    birthdayService.sendGreetings(today());
}
```

Note that the **collaborators** of the `birthdayService` objects are **injected** in it. Ideally **domain** code should never use the `new` operator. The `new` operator is called from outside the domain code, to set up an **aggregate** of objects that collaborate together.

**An optional complication**

If you want to develop further the domain logic, you can take into account the special rule for people born on a 29th of February: they should be sent greetings on the 28th of February, except in leap years, when they will get their greetings on the 29th.

### Testability

A test is not a **unit test** if:

- It talks to a database
- It communicates across the network
- It touches the file system
- You have to do things to your environment to run it (eg, change config files, comment line)

**Tests that do this are integration tests.**

One way to make code more testable is to use Dependency Injection. This means that an object should never instantiate its collaborator by calling the new operator. It should be passed its collaborators instead. When we work this way we separate classes in two kinds.

1. **Application logic** classes have their collaborators passed into them in the constructor.
2. **Configuration** classes build a network of objects, setting up their collaborators.

**Application logic classes contain a bunch of logic, but no calls to the new operator.** 

**Configuration classes contain a bunch of calls to the new operator, but no application logic.**


----

See https://github.com/xpmatteo/birthday-greetings-kata/tree/master
See http://matteo.vaccari.name/blog/archives/154
See http://matteo.vaccari.name/blog/

See https://github.com/adelatorrefoss/code-smells-refactoring-training-java/tree/master/04-refactoring-to-hexagonal-architecture-2

See https://github.com/adelatorrefoss/code-smells-refactoring-training-java/tree/master/02-refactoring-video-store

See https://github.com/adelatorrefoss/practice_program/tree/master/katas_java/07-refactoring-to-hexagonal-architecture-2