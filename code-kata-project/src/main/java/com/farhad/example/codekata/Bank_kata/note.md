See https://github.com/sandromancuso/Bank-kata
See https://github.com/adelatorrefoss/practice_program/tree/master/katas_java/10-outside-in-with-bank-kata

See https://github.com/adelatorrefoss/practice_program/tree/sesion_10/katas_java/10-outside-in-with-bank-kata

### Requirements

> Deposit and Withdrawal  
> Transfer  
> Account statement (date, amount, balance)  
> Statement printing  
> Statement filters (just deposits, withdrawal, date)

The Rules

1. One level of indentation per method
2. Don’t use the ELSE keyword
3. Wrap all primitives and Strings
4. First class collections
5. One dot per line
6. Don’t abbreviate
7. Keep all entities small (50 lines)
8. No classes with more than two instance variables
9. No getters/setters/properties


     

For more information:

- [Object Calisthenics pdf](Started from defining an acceptance test:)
- Object Calisthenics (full book), Jeff Bay in: The ThoughtWorks Anthology. Pragmatic Bookshelf 2008
- Original idea for the kata: How Object-Oriented Are You Feeling Today? - Krzysztof Jelski (Session on the Software Craftsmanship UK 2011 conference)

Started from defining an acceptance test:

**Given** a client makes a deposit of 1000 on 10-01-2012
**And**   a deposit of 2000 on 13-01-2012
**And**   a withdrawal of 500 on 14-01-2012
**When**  she prints her bank statement
**Then**  she would see

```
date || credit || debit || balance
14/01/2012 || || 500.00 || 2500.00
13/01/2012 || 2000.00 || || 3000.00
10/01/2012 || 1000.00 || || 1000.00
```


You have to write and make the following acceptance test pass using outside-in TDD:

Given a client makes a deposit of 1000 on 10-01-2012
And a deposit of 2000 on 13-01-2012
And a withdrawal of 500 on 14-01-2012

When she prints her bank statement

Then she would see

```
date       || credit  || debit  || balance
14/01/2012 ||         || 500.00 || 2500.00
13/01/2012 || 2000.00 ||        || 3000.00
10/01/2012 || 1000.00 ||        || 1000.00

```

The goal of the exercise is to understand the outside-in TDD style.