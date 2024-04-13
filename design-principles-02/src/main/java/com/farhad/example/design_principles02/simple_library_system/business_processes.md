From Object-Oriented Analysis, Design and Implementation An Integrated Approach book

## Library System

### Gathering the Requirements


The business processes of the library system are listed below.

- **Register new members** The library receives applications from people who want to become library members, whom we alternatively refer to as users. While applying for membership, a person supplies his/her name, phone number and address to the library. The library assigns each member a unique identifier (ID), which is needed for transactions such as issuing books.

- **Add books to the collection** We will make the assumption that the collection includes just books. For each book the library stores the title, the author’s name, and a unique ID. (For simplicity, let us assume that there is only one author per book. If there are multiple authors, let us say that the names will have to be concatenated to get a pretty huge name such as ‘Brahma Dathan and Sarnath Ramnath’. As a result, to the system, it appears that there is just one author.) When it is added to the collection, a book is given a unique identifier by the clerk. This ID is based on some standard system of classification.

- **Issue a book to a member (or user)** To check out books, a user (or member) must identify himself to a clerk and hand over the books. The library remembers that the books have been checked out to the member. Any number of books may be checked out in a single transaction.

- **Recorde the return of a book** To return a book, the member gives the book to a clerk, who submits the information to the system, which marks the book as ‘not checked out’. If there is a hold on the book, the system should remind the clerk to set the book aside so that the hold can be processed.

- **Remove books from the collection** From time to time, the library may remove books from its collection. This could be because the books are worn-out, are no longer of interest to the users, or other sundry reasons.

- **Print out a user's transactions** Print out the interactions (book checkouts, returns, etc.) between a specific user and the library on a certain date.

- **Place/remove a hold on a book** When a user wants to put a hold, he/she supplies the clerk with the book’s ID, the user’s ID, and the number of days after which the book is not needed. The clerk then adds the user to a list of users who wish to borrow the book. If the book is not checked out, a hold cannot be placed. To remove a hold, the user provides the book’s ID and the user’s ID.

- **Renew books issued to a member** Customers may walk in and request that several of the books they have checked out be renewed (re-issued). The system must display the relevant books, allow the user to make a selection, and inform the user of the result.

- **Notify member of book's availability** Customers who had placed a hold on a book are notified when the book is returned. This process is done once at the end of each day. The clerk enters the ID for each book that was set aside, and the system returns the name and phone number of the user who is next in line to get the book.


In addition, the system must support three other requirements that are not directly related to the workings of a library, but, nonetheless, are essential.

- A command to save the data on a long-term basis.
- A command to load data from a long-term storage device.
- A command to quit the application. At this time, the system must ask the user if data is to be saved before termination.

### Functional Requirements Specification

#### Use Case Analysis

Use case analysis is a case-based way of describing the uses of the system with the goal of defining and documenting the system requirements. It is essentially a narrative describing the sequence of events (actions) of an external agent (actor) using the system to complete a process. It is a powerful technique that describes the kind of functionality that a user expects from the system.

Use cases have two or more parties: agents who interact with the system and the system itself. In our simple library system, the members do not use the system directly. Instead, they get services via the library staff.

To initiate this process, we need to get a feel for how the system will interact with the end-user. We assume that some kind of a user-interface is required, so that when the system is started, it provides a menu with the following choices:

1. Add a member (Add Member)
2. Add books (Add Book)
3. Issue books (Issue Books)
4. Return books (Return Books)
5. Remove books (Remove Books)
6. Place a hold on a book (Place Hold)
7. Remove a hold on a book (Remove Hold)
8. Process Holds: Find the first member who has a hold on a book (Process Holds)
9. Renew books (Renew Books)
10. Print out a member’s transactions (Print Transactions)
11. Store data on disk (Save Data)
12. Retrieve data from disk (Retrieve Data)
13. Exit (Exit)

There are some implicit requirements associated with these operations. For instance, when a book is checked out, the system must output a due-date so that the clerk can stamp the book. This and other such details will be spelled out when we elaborate on the use cases.

The actors in our system are members of the library staff who manage the daily operations.

In order to keep the discussion within manageable size and not lose focus, we make the following assumption: While the use cases will state the need for the system to display different messages prompting the user for data and informing the results of operations, the user community is not fussy about the minute details of what the messages should be; any meaningful message is acceptable. For example, we may specify in a use case that the system ‘informs the clerk if the member was added’. The actual message could be any one of a number of possibilities such as ‘Member added’, or ‘Member registered’, etc.

Recall that use cases are specified in a two-column format, where the left-column states the actions of the actor and the right-column shows what the system does.


##### Use case registering new  member

| Actions performed by the actor | Responses from the system |
| -----------------------------  | -------------------------|
| 1. The customer fills out an application form<br/> containing the customer's name, address, and<br/> phone number and given this to the clerk |    | 
| 2. The clerk issue a request to add a new<br/> member |   |
|   | 3. The system ask for data about the new<br/> member  |
| 4. The clerk enters data into the system |  | 
|  | 5. Reads in data, and if the member can be<br/>added, generates an identification number<br/>(which is not necessarily a number in the literal<br/>sense just as social security numbers and phone<br/>numbers are not actually numbers) for the<br/>member and remembers information about the<br/>member. Informs the clerk if the member was<br/>added and outputs the member’s name,<br/>address, phone and id |
| 6. The clerk gives the user his identification<br/>number  |   | 


##### Use case Add New Books

| Actions performed by the actor | Responses from the system |
| -----------------------------  | -------------------------|
| 1. Library receives a shipment of books from<br/>the publisher |    | 
| 2. The clerk issues a request to add a new book |   |
|   | 3. The system asks for the identifier, title, and<br/>author name of the book  |
| 4. The clerk generates the unique identifier,<br/>enters the identifier, title, and author name of a<br/>book |  | 
|  | 5. The system attempts to enter the information<br/>in the catalog and echoes to the clerk the title,<br/>author name, and id of the book. It then asks if<br/>the clerk wants to enter information about<br/>another book |
| 6. The clerk answers in the affirmative or in the<br/>negative  |   | 
|  | 7. If the answer is in the affirmative, the system<br/>goes to Step 3. Otherwise, it exits |   | 


##### Use Case Book Checkout (Issuing Books)

| Actions performed by the actor | Responses from the system |
| -----------------------------  | -------------------------|
| 1. the member arrives at the check-out counter <br/>with a set of books and supplies the clerk with <br/>his/her identification number |    | 
| 2. The clerk issues a request to check out books |   |
|   | 3. The system asks for the user ID  |
| 4. The clerk inputs the user ID to the system |  | 
|  | 5. The system asks for the ID of the book |
| 6. The clerk inputs the ID of a book that the <br/>user wants to check out  |   | 
|  | 7. The system records the book as having been <br/>issued to the member; it also records the <br/>member as having possession of the book. It <br/>generates a due-date. The system displays the <br/>book title and due-date and asks if there are any <br/>more books |   | 
| 8. the clerk stamps the due-date on the book <br/>and replies in the affirmative or negative |   |
|    |  9. if there are more books, the system moves to <br/>Step 5; otherwise it exits  |
|  10. the customer collects the books and leaves <br/>the counter  |    | 

There are some drawbacks to the way this use case is written. One is that it does not specify how due-dates are computed. We may have a simple rule (example: due-dates are one month from the date of issue) or something quite complicated (example: due-date is dependent on the member’s history, how many books have been checked out, etc.). Putting all these details in the use case would make the use case quite messy and harder to understand. Rules such as these are better expressed as **Business Rules**. A business rule may be applicable to one or more use cases.


Rules for the library system:

| Rule number | Rule |
| ----- | ------ |
Rule 1  | Due-date for a book is one month from the date of issue
Rule 2  | All books are issuable
Rule 3  | A book is removable if it is not checked out and if it has no holds
Rule 4  | A book is renewable if it has no holds on it
Rule 5  | When a book with a hold is returned, the appropriate member will be notified
Rule 6  | Holds can be placed only on books that are currently checked out


A second problem with the use case is that as written above, it does not state what to do in case things go wrong. For instance,

1. The person may not be a member at all. How should the use case handle this situation? We could abandon the whole show or ask the person to register.

2. The clerk may have entered an invalid book id.



| Actions performed by the actor | Responses from the system |
| -----------------------------  | -------------------------|
| 1. the member arrives at the check-out counter <br/>with a set of books and supplies the clerk with <br/>his/her identification number |    | 
| 2. The clerk issues a request to check out books |   |
|   | 3. The system asks for the user ID  |
| 4. The clerk inputs the user ID to the system |  | 
|  | 5. If the ID is valid, the system asks for the ID <br/>of the book; otherwise it prints an approprate <br/>message and exits the use case |
| 6. The clerk inputs the ID of a book that the <br/>user wants to check out  |   | 
|  | 7. If the ID is valid and the book is issuable to <br/>the member, the system records the book as <br/>having been issued to the member; it also records <br/>the member as having possession of the book <br/>and generates a due-date as in Rule 1. it then <br/>displays the book title and due-date. if the <br/>book is not issuable as per Rule 2, the system <br/>displays a suitable error message. The system <br/> asks if there are more books |   | 
| 8. The clerk stamps the due-date, prints out the <br/>transaction (if needed) and replies positively or <br/>negatively |   |
|    |  9. if there are more books, the system moves to <br/>Step 5; otherwise it exits  |
|  10. The clerk stamps the due date and gives the <br/>user the books checked out. The customer <br/>leaves the counter  |    | 


##### Use Case Return Book

| Actions performed by the actor | Responses from the system |
| -----------------------------  | -------------------------|
| 1. the member arrives at the return  counter <br/>with a set of books and leaves them on the <br/>clerk's desk |    | 
| 2. The clerk issues a request to return books |   |
|   | 3. The system asks for the identifier of the book |
| 4. The clerk enters the book identifier |  | 
|  | 5. If the identifier is valid, the system marks <br/>that the book has been returned and informs the <br/>clerk if there is a hold placed on the book; <br/>otherwise it notifies the clerk that the identifier <br/>is not valid. It then asks if the clerk wants to <br/>process the return of another book |
| 6. The clerk answers in the affirmative or in the <br/>negative and sets the book aside in case there is <br/>a hold on the book (see Rule 5)  |   | 
|  | 7. If the answer is in the affirmative, the system <br/>goes to Step 3. Otherwise, it exits |   | 


##### Use Case Removing Books

| Actions performed by the actor | Responses from the system |
| -----------------------------  | -------------------------|
| 1. Librarian identifies the books to be deleted |    | 
| 2. The clerk issues a request to delete books |   |
|   | 3. The system asks for the identifier of the book |
| 4. The clerk enters the ID for the book |  | 
|  | 5. The system checks if the book can be <br/>removed using Rule 3. If the book can be <br/>removed, the system marks the book as no <br/>longer in the library’s catalog. The system <br/>informs the clerk about the success of the <br/>deletion operation. It then asks if the clerk <br/>wants to delete another book |
| 6. The clerk answers in the affirmative or in the negative  |   | 
|  | 7. If the answer is in the affirmative, the system <br/>goes to Step 3. Otherwise, it exits |   | 



##### Use Case Member Transactions

| Actions performed by the actor | Responses from the system |
| -----------------------------  | -------------------------|
| 1. The clerk issues a request to get member transactions |    | 
|   |  2. The system asks for the user ID of the <br/>member and the date for which the transactions <br/>are needed |
|   | 3.The clerk enters the identity of the user and the date |
|  |  4. If the ID is valid, the system outputs <br/>information about all transactions completed <br/>by the user on the given date. For each <br/>transaction, it shows the type of transaction <br/>(book borrowed, book returned or hold placed) <br/>and the title of the book | 
| 5. Clerk prints out the transactions and hands <br/>them to the user |   |


##### Use Case Place a Hold

| Actions performed by the actor | Responses from the system |
| -----------------------------  | -------------------------|
| 1. The clerk issues a request to place a hold |    | 
|   |  2. The system asks for the book’s ID, the ID of <br/>the member, and the duration of the hold	 |
|  3. The clerk enters the identity of the user, the <br/>identity of the book and the duration |   |
|  |  4. The system checks that the user and book <br/>identifiers are valid and that Rule 6 is satisfied. <br/>If yes, it records that the user has a hold on the <br/>book and displays that; otherwise, it outputs an <br/>appropriate error message | 

##### Use Case Remove a Hold

| Actions performed by the actor | Responses from the system |
| -----------------------------  | -------------------------|
| 1. The clerk issues a request to REMOVE a hold |    | 
|   |  2. The system asks for the book’s ID, the ID of <br/>the member	 |
|  3. The clerk enters the identity of the user and the <br/>identity of the book |   |
|  |  4. The system removes the hold that the user <br/>has on the book (if any such hold exists), prints <br/>a confirmation and exits | 


##### Use Case Process a Hold

| Actions performed by the actor | Responses from the system |
| -----------------------------  | -------------------------|
| 1. The clerk issues a request to process holds <br/>(so that Rule 5 can be satisfied)   |    | 
|   | 2. The system asks for the book’s ID 	 |
|  3. The clerk enters the ID of the book |    |
|   |  4. The system returns the name and phone <br/>number of the first member with an unexpired <br/>hold on the book. If all holds have expired, the <br/>system responds that there is no hold. The <br/>system then asks if there are any more books to <br/>be processed  | 
|  5. If there is no hold, the book is then shelved <br/>back to its designated location in the library. <br/>Otherwise, the clerk prints out the information, <br/>places it in the book and replies in the <br/>affirmative or negative |    | 
|   |  6. If the answer is yes, the system goes to <br/>Step 2; otherwise it exits  | 



this use case deals with process- ing the holds at the end of each day. In this case, once the contact information for the member has been printed out, we assume that the library will contact the member. The member may not come to collect the book within the specified time, at which point the library will try to contact the next member in line. All this is not included in the use case. If we were to do so, the system would, in essence, be waiting on the user’s response for a long period of time. We therefore leave out these steps and when the next user has to be contacted, we simply process holds on the book once again.

##### Use Case Renew Books

This use case deals with situations where a user has several books checked out and would like to renew some of these. The user may not remember the details of all of them and would perhaps like the system to prompt him/her. We shall assume that users only know the titles of the books to be renewed (they do not bring the books or even the book ids to the library) and that most users would have borrowed only a small number of books. In this situation, it is entirely appropriate for the system to display the title of each book borrowed by the user and ask if that book should be renewed.

| Actions performed by the actor | Responses from the system |
| -----------------------------  | -------------------------|
|  1. Member makes a request to renew several of <br/>the books that he/she has currently checked out  |    | 
|  2. Clerk issues a request to renew books  |    |
|    |  3. System asks for the member’s ID  |
|  4. The clerk enters the ID into the system  |    | 
|    |  5. System checks the member’s record to find <br/>out which books the member has checked out. <br/>If there are none, the system prints an <br/>appropriate message and exits; otherwise it <br/>moves to Step 6   | 
|    |  6. The system displays the title of the next book <br/>checked out to the member and asks whether <br/>the book should be renewed  | 
|  7. The clerk replies yes or no  |    | 
|    |  8. The system attempts to renew the book using <br/>Rule 4 and reports the result. If the system has <br/>displayed all checked-out books, it reports that <br/>and exits; otherwise the system goes to Step 6  | 


It may be the case that a library has additional rules for renewability: if a book has a hold or a member has renewed a book twice, it might not be renewable. In the above interaction, the system displays all the books and determines the renewability only if the member wishes to renew the book. A different situation could arise if we require that the system display only the renewable books. (The system would have to have a way for checking renewability without actually renewing the book, which places additional requirements on the system’s functionality.)

#### How do Business Rules Relate to Use Cases?

Business rules can be broadly defined as the details through which a busi-
ness implements its strategy. Business analysts perform the task of gathering
business rules, and these belong to one of four categories:

- Definitional rules which explain what is meant when a certain word is used
in the context of the business operations. These may include special technical
terms, or common words that have a particular significance for the business.
For instance the term Book in the context of the library refers to a book
owned by the library.

- Factual rules which explain basic things about the business’s operations;
they tell how the terms connect to each other. A library, for instance, would
have rules such as ‘Books are issued to Members,’ and ‘Members can place
holds on Books’.

- Constraints which are specific conditions that govern the manner in which
terms can be connected to each other. For instance, we have a constraint that
says ‘Holds can be placed only on Books that are currently checked out’.

- Derivations which are knowledge that can be derived from the facts and
constraints. For instance, a bank may have the constraint, “The balance in
an account cannot be less than zero,” from which we can derive that if an
amount requested for withdrawal is more than the balance, then the operation
is not successful.

When writing use cases, we are mainly concerned with constraints and deriva-
tions. Typically, such business rules are in-lined with the logic of the use-case.
The use-case may explicitly state the test that is being performed and cite
the appropriate rule, or may simply mention that the system will respond in
accordance with a specific rule.

In addition to the kinds of rules we have presented for this case study, there
are always implicit rules that permeate the entire system. A common example
of this is validation of input data; a zip code, for instance, can be validated
against a database of zip-codes. Note that this rule does not deal with how
entities are connected to one another, but specifies the required properties of a
data element. Such constraints do not belong in use cases, but could be placed
in classes that store the corresponding data elements.


### Guidelines to Remember When Writing Use Cases

- A use case must provide something of value to an actor or to the business: when the scenario described in the use case has played out, the actor has accomplished some task. The system may have other functions that do not provide value; these will be just steps within a use case. This also implies that each use case has at least one actor.

- Use cases should be functionally cohesive, i.e., they encapsulate a single service that the system provides.

- Use cases should be temporally cohesive. This notion applies to the time frame over which the use case occurs. For instance, when a book with a hold is returned, the member who has the hold needs to be notified. The notification is done after some delay; due to this delay, we do not combine the two operations into one use case. Another example could be a university registration system—when a student registers for a class, he or she should be billed. Since the billing operation is not temporally cohesive with the registration, the two constitute separate use cases.

- If a system has multiple actors, each actor must be involved in at least one, and typically several use cases. If our library allowed members to check out books by themselves, “member” is another possible actor.

- The model that we construct is a set of use cases, i.e., there is no relationship between individual use cases.

- Exceptional exit conditions are not handled in use cases. For instance, if a system should crash in the middle of a use case, we do not describe what the system is supposed to do. It is assumed that some reasonable outcome will occur.

- Use cases are written from the point of view of the actor in the active voice.

- A use case describes a scenario, i.e., tells us what the visible outcome is and does not give details of any other requirements that are being imposed on the system.

- Use cases change over the course of system analysis. We are trying to construct a model and consequently the model is in a state of evolution during this process. Use cases may be merged, added or deleted from the model at any time.


### Defining Conceptual Classes and Relationships

As we discussed earlier, the last major step in the analysis phase involves the determination of the conceptual classes and the establishment of their relationships. For example, in the library system, some of the major conceptual classes include members and books. Members borrow books, which establishes a relationship between them.

In practice, an analyst will probably use multiple methods to come up with the conceptual classes and their relationships. In this case study, however, we use a simple approach: we examine the use cases and pick out all the nouns in the description of the requirements. For example, from the text of the use case for registering new users, we can pick out the nouns.

Here is the text of that use case, once again, with all nouns bold-faced:

(1) The **customer** fills out an **application form** containing the **customer’s name**, **address**, and **phone number** and gives this to the **clerk**. (2) The **clerk** issues a **request** to add a new **member**. (3) **The system** asks for **data** about the new **member**. (4) The **clerk** enters the **data** into the **system**. (5) Reads in **data**, and if the **member** can be added, generates an **identification number** for the **member** and remembers **information** about the **member**. Informs the clerk if the member was added and outputs the **member’s name**, **address**, **phone**, and **id**. (6) The **clerk** gives the **user** his **identification number**.

Let us examine the nouns. First, let us eliminate duplicates to get the following list:

**customer, application form, customer’s name, address, phone number, clerk, request, system, data, identification number, member, user, member information, and member’s name.** Some of the nouns such as **member** are composite entities that qualify to be classes.

While using this approach, we must remember that natural languages are imprecise and that synonyms may be found. We can eliminate the others as follows:

1. **customer**: becomes a member, so it is effectively a synonym for member.
2. **user**: the library refers to members alternatively as users, so this is also a synonym.
3. **application form** and **request**: application form is an external construct for gathering information, and request is just a menu item, so neither actually becomes part of the data structures.
4. **customer’s name**, **address**, and **phone number**: They are attributes of a cus-
tomer, so the Member class will have them as fields.
5. **clerk**: is just an agent for facilitating the functioning of the library, so it has no
software representation.
6. **identification number**: will become part of a member.
7. **data**: gets stored as a member.
8. **information**: same as data related to a member.
9. **system**: refers to the collection of all classes and software.

The noun **system** implies a conceptual class that represents all of the software; we call this class *Library*. Although we do not have as yet any specifics of this class, we note its existence and represent it in UML without any attributes and methods.

A **member** is described by the attributes name, address, and phone number. Moreover, the system generates an identifier for each user, so that also serves as an attribute.

The use case *Register New Member* says that the system ‘remembers information about the member’. This implies an association between the conceptual classes *Library* and *Member*.

    +---------+ 1         maintains a collection of            * +--------+ 
    | Library |--------------------------------------------------| Member |
	+---------+                                                  +--------+


Obviously, members and books are the most central entities in our system: the sole reason for the library’s existence is to provide service to its members and that is effected by letting them borrow books. Just as we reasoned for the existence of a conceptual class named *Member*, we can argue for the need of a conceptual class called *Book* to represent a book. It has attributes *id*, *title*, and *author*.


    +---------+ 1         maintains a collection of            * +------+ 
    | Library |--------------------------------------------------| Book |
	+---------+                                                  +------+

Some associations are *static*, i.e., permanent, whereas others are *dynamic*. Dynamic associations are those that change as a result of the transactions being recorded by the system. **Such associations are typically associated with verbs.**

As an example of a dynamic association, consider members borrowing books. This is an association between *Member* and *Book*. At any instant in time, a book can be borrowed by one member and a member may have borrowed any number of books. We say that the relationship *Borrows* is a one-to-many relationship between the conceptual classes *Member* and *Book* and indicate it by writing 1 by the side of the box that represents a user and the * near the box that stands for a book.


    +---------+ 1                  Borrows                     * +------+ 
    |  Member |--------------------------------------------------| Book |
	+---------+                                                  +------+

Another action that a member can undertake is to place a hold on a book. Several users can have holds placed on a book, and a user may place holds on an arbitrary number of books. In other words, this relationship is many-to-many between *users* and *books*. We represent this by putting a * at both ends of the line representing the association.


    +---------+ *                    Holds                     * +------+ 
    |  Member |--------------------------------------------------| Book |
	+---------+                                                  +------+

We capture all of the conceptual classes and their associations into a single diagram. As seen before, a relationship formed between two entities is sometimes accompanied by additional information. This additional information is relevant only in the context of the relationship. There are two such examples in the inter-class relationships we have seen so far: when a user **borrows a book** and when a user **places a hold on a book**. Borrowing a book introduces new information into the system, viz., the date on which the book is due to be returned. Likewise, placing a hold introduces some information, viz., the date after which the book is not needed. The lines representing the association are augmented to represent the information that must be stored as part of the association. For the association *Borrows* and the line connecting *Member* and *Book*, we come up with a conceptual class named *Borrows* having an attribute named *dueDate*. Similarly, we create a conceptual class named *Holds* with the attribute called *date* to store the information related to the association *Holds*. Both these conceptual classes are attached to the line representing the corresponding associations.

It is important to note that the above conceptual classes or their representation do not, in any way, tell us how the information is going to be stored or accessed. Those decisions will be deferred to the design and implementation phase. For instance, there may be additional classes to support the operations of the *Library* class. We may discover that while some of the conceptual classes have corresponding physical realisations, some may disappear and the necessary information may be stored as fields distributed over multiple classes. We may discover that while some of the conceptual classes have corresponding physical realisations, some may disappear and the necessary information may be stored as fields distributed over multiple classes. We may choose to move fields that belong to an association elsewhere. For instance, the field *dueDate* may be stored as a field of the book or as a separate object, which holds a reference to the book object and the user object involved. Upon making that choice, the designer decides how the conceptual relationship between User and Book is going to be physically realised. The conceptual class diagram is simply that: **conceptual**.


                            maintains a collection of
        /--------------------------------------------------------------\
        |                                                              | *
        |                                                        1 +--------+ *
		|                                                    /-----| Member |-----\
		|													 |	   +--------+     |
        |                        +-----------+               |                    |
        | 1                      |  Borrows  |               |                    |           +--------+  
   +---------+                   +-----------+---------------|                    |           | Holds  | 
   | Library |                   | - dueDate |               |                    |-----------+--------+
   +---------+                   +-----------+               |                    |           | - date |
        | 1                                                  |                    |           +--------+
        |													 |   * +--------+  *  |
		|   											     \-----|  Book  |-----/
		|														   +--------+
        |                   maintains a collection of                   | *
        \---------------------------------------------------------------/


### Using the Knowledge of the Domain

Any area in which we develop software systems qualifies to be a **domain**. Examples include library systems, hotel reservation systems, university registration systems, etc. We can sometimes divide a domain into several interrelated domains. For example, we could say that the domain of **university applications** includes the domain of *course management*, the domain of *student admissions*, the domain of *payroll applications*, and so on. Such a domain can be quite complex because of the interactions of the smaller domains that make up the bigger one.

Before we analyse and construct a specific system, we first need to perform an exhaustive analysis of the class of applications in that domain. In the domain of libraries, for example, there are things we need to know including the following.

1. The environment, including customers and users. Libraries have loanable items such as books, CDs, periodicals, etc. A library’s customers are members. Libraries buy books from publishers.

2. Terminology that is unique to the domain. For example, the Dewey decimal classification (DDC) system for books.

3. Tasks and procedures currently performed. In a library system, for example:
  
  - Members may check out loanable items.
  - Some items are available only for reference; they cannot be checked out.
  - Members may put holds on loanable items.
  - Members will pay a fine if they return items after the due date.


One of the major activities of this analysis is discovering the business rules, the rules that any properly-functioning system in that domain must conform to.

Where does the knowledge of a specific domain come from? It could be from sources such as **surveys**, **existing applications**, **technical reports**, **user manuals**, and so on.



#### Finding the Right Classes

In general, finding the right classes is non-trivial. It must be remembered that this process is iterative, i.e., we start with a set of classes and complete a conceptual design. In the process of walking through the use case implementations, we may find that some classes have to be dropped and some others have to be added. Familiarity with Design Patterns also helps in recognizing the classes. The following thumb rules and caveats come in handy:


- In general, do not build classes around functions. There are exceptions to this rule. Write a class description. If it reads ‘This class performs...’ we most likely have a problem. If class name is imperative, e.g., print, parse, etc., it is likely that either the class is wrong or the name is wrong.

- Remember that a class usually has more than one method; otherwise it is probably a method that should be attached to some other class.

- Do not form an inheritance hierarchy too soon unless we have a pre-existing taxonomy. (Inheritance is supposed to be a relationship among well-understood abstractions.)

- Be wary of classes that have no methods, (or only query methods) because they are not frequent. Some situations in which they occur are: (i) representing objects from outside world, (ii) encapsulating facilities, constants or shared variables, (iii) applicative classes used to describe non-modifiable objects, e.g., integer class in Java generates new integers, but does not allow modification of integers.

- Check for the following properties of the ideal class: (i) a clearly associated abstraction, which should be a data abstraction (as opposed to a process abstraction), (ii) a descriptive noun/adjective for the class name, (iii) a non-empty set of runtime objects, (iv) queries and commands, (v) abstract prop- erties that can be described as pre/post conditions and invariants.


#### Creating the Software Classes

The next step is to create the software classes. During the analysis, after defining the
use case model, we came up with a set of conceptual classes and a conceptual class
diagram for the entire system. As mentioned earlier, these come from a conceptual or
essential perspective. The software classes are more ‘concrete’ in that they correspond
to the software components that make up the system. In this phase there are two major
activities.

1. Come up with a set of classes.
2. Assign responsibilities to the classes and determine the necessary data structures and methods.

In general, it is unlikely that we can come up with a design simply by doing these
activities exactly once. Several iterations may be needed and classes may need to be
added, split, combined, or eliminated.

As we are having just a rudimentary text-based interface, the UI subsystem will
consist of a single class, aptly named UserInterface. The classes for the business
logic module will be the ones instrumental in implementing the system requirements
described in the use case model. In our analysis, we came up with a set of conceptual
classes and relationships. It is, therefore, reasonable that as a ‘first guess’ for the
required software classes for the business logic, we pick these conceptual classes. A
closer scrutiny of these is now in order.

1. Member and Book These are central concepts. Each Member object comprises
several attributes such as name and address, stays in the system for a long period
of time and performs a number of useful functions. Books stay part of the library
over a long time and we can do a number of useful actions on them. We need to
instantiate books and members quite often. Clearly, both are classes that require
representation in software.
2. Library Do we really need to make a class for this? To answer the question, let
us ask what the real library—not a possible object—has. It keeps track of books
and members. When a member thinks of a library, he/she thinks of borrowing and
returning books, placing and removing holds, i.e., the functionality provided by
the library. To model a library with software, we need to mimic this functionality,
which we did by creating a use case model. The use case behaviour is what is
exhibited by the UI, and to meet the required specifications, the UI must perform
some other computations that involve the module that implements the business
logic. One of the important principles of object-oriented design is that every
computation must be represented as an application of a method on a given object,
which is then treated as the current object for the computation. All the computation
required of the business logic module must be executed on some current object;
that object is a Library. This requires that Library be a class in its own
right, and the operations required of the business logic module correspond to the
methods of this class.
Although details of its functionality remain to be determined by examining the
use cases, with some thought we can come up with two important aspects of the
Library class. As we have seen in Chap. 6, the Library instance must keep
track of the members of the library as well as the books, which obviously imply
maintenance of two collection objects. The functionality of these two collections
is again to be determined, but it is likely that we need two different classes,
MemberList and Catalog, which may be alike in certain respects.1 These
two collections last as long as the library itself, and we make modifications to them
very frequently. The actions that we perform are not supported by programming
languages although there may be some support in the associated packages such as
the list classes in the Java Development Kit. All these would suggest that they be
classes. However, we create them just once. As we know from Chap. 5, a class that
has just one instance is called a singleton. Both MemberList and Catalog
are singletons.

3. Borrows This class represents the one-to-many relationship between members
and books. In typical one-to-many relationships, the association class can be
efficiently implemented as a part of the two classes at the two ends. To verify
this for our situation, for every pair of member m and book b such that m has
borrowed b, the corresponding objects simply need to maintain a reference to
each other. Since a member may borrow multiple books, this arrangement entails
the maintenance of a list of Book objects in Member, but since there is only a
single borrower for a book, each Book object needs to store a reference to only
one instance of Member. Further examining the role played by the information in
Borrows, we see that when a book is checked out, the due date can be stored in
Book. In general, this means that all attributes that are unique to the relationship
may be captured by storing information at the ‘many’ end of the relationship.
When the book is returned, the references between the corresponding Member
and Book objects as well as the due date stored in Book can be ‘erased.’
This arrangement efficiently supports queries arising in almost any situation: a
user wanting to find out when her books are due, a staff member wanting to know
the list of books borrowed by a member, or an anxious user asking the librarian
when he can expect the book on which he placed a hold. In all these situations
we have operations related to some Member and Book objects.

4. Holds Unlike Borrows, this class denotes a many-to-many relationship between
the Member and Book classes. In typical many-to-many relationships, implemen-
tation of the association without using an additional class is unlikely to be clean
and efficient. To attempt to do this without an additional class in the case of holds,
we would need to maintain within each Member object references to all Book
instances for which there is a hold, and keep ‘reverse’ references from the Book
objects to the Member objects. This is, however, incomplete because we also
need to maintain for each hold the number of days for which it is valid. But there
is no satisfactory way of associating this attribute with the references. We could
have queries like a user wanting a list of all of his holds that expire within 30
days. The reader can verify that implementations without involving an additional
class will be messy and inefficient.
It is, therefore, appropriate that we have a class for this relationship and make
the Hold object accessible to the instances of Member and Book.

4. Holds Unlike Borrows, this class denotes a many-to-many relationship between
the Member and Book classes. In typical many-to-many relationships, implemen-
tation of the association without using an additional class is unlikely to be clean
and efficient. To attempt to do this without an additional class in the case of holds,
we would need to maintain within each Member object references to all Book
instances for which there is a hold, and keep ‘reverse’ references from the Book
objects to the Member objects. This is, however, incomplete because we also
need to maintain for each hold the number of days for which it is valid. But there
is no satisfactory way of associating this attribute with the references. We could
have queries like a user wanting a list of all of his holds that expire within 30
days. The reader can verify that implementations without involving an additional
class will be messy and inefficient.

It is, therefore, appropriate that we have a class for this relationship and make
the Hold object accessible to the instances of Member and Book.


#### Assigning Responsibilities to the Classes


