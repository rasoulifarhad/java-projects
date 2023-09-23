### Application Services

An application service acts as a facade through which clients will interact with the domain model. Application services have the following characteristics:

- They are stateless
- They enforce system security
- They control the database transactions
- They orchestrate business operations but do not make any business decisions (i.e., they do not contain any business logic)


####  Statelessness

An application service does not maintain any internal state that can be changed by interacting with clients. All the information that is needed to perform an operation should be available as input parameters to the application service method. This will make the system simpler and easier to debug and scale.

If you find yourself in a situation where you have to make multiple application service calls within the context of a single business process, you can model the business process in a class of its own and pass an instance of it as an input parameter to the application service method. The method would then do its magic and return an updated instance of the business process object that in turn can be used as input to other application service methods.

#### Security Enforcement 

The application service makes sure that the current user is allowed to perform the operation in question. Technically, you can do this manually at the top of each application service method or use something more sophisticated such as AOP. It does not matter how security is enforced as long as it happens in the application service layer and not inside the domain model. 

#### Transaction Management 

Every application service method should be designed in such a way that it forms a single transaction of its own, regardless of whether the underlying data storage uses transactions or not. If an application service method succeeds, there is no way of undoing it except by explicitly invoking another application service that reverses the operation (if such a method even exists).

If you find yourself in a situation where you would want to invoke multiple application service methods within the same transaction, you should check that the granularity of your application service is correct. Maybe some of the things your application service is doing should actually be in domain services instead?

You may also need to consider redesigning your system to use eventual consistency instead of strong consistency.

####  Orchestration

By orchestration, I mean looking up and invoking the correct domain objects in the correct order, passing in the correct input parameters and returning the correct output. 

In its simplest form, an application service may look up an aggregate based on an ID, invoke a method on that aggregate, save it and return. 

in more complex cases, the method may have to look up multiple aggregates, interact with domain services, perform input validation and so on.

If you find yourself writing long application service methods, you should ask yourself the following questions:

- Is the method making a business decision or asking the domain model to make the decision?
- Should some of the code be moved to domain event listeners?

#### Domain Event Listeners

domain event listener should not be able to affect the outcome of the method that published the event in the first place. In practice, this means that a domain event listener should run inside its own transaction.

Because of this, I consider domain event listeners to be a special kind of application service that is invoked not by a client but by a domain event. In other words: domain event listeners belong in the application service layer and not inside the domain model. This also means that a domain event listener is an orchestrator that should not contain any business logic.

Depending on what needs to happen when a certain domain event is published, you may have to create a separate domain service that decides what to do with it if there is more than one path forward.

#### Input and Output 

One important decision when designing application services is to decide what data to consume (method parameters) and what data to return. You have three alternatives:

1. Use the entities and value objects directly from the domain model.
2. Use separate Data Transfer Objects (DTOs).
3. Use Domain Payload Objects (DPOs) that are a combination of the two above.

Each alternative has its own pros and cons, so let's have a closer look at each.

#### Input Validation

An aggregate must always be in a consistent state. This means among other things that we need to properly validate all the input that is used to alter the state of an aggregate.

When thinking about input validation there are actually two distinct kinds of validation: 

- format validation and 
- content validation
  
When we are validating the format, we check that certain values of certain types conform to certain rules. E.g. a social security number is expected to be in a specific pattern. 

When we are validating the content, we already have a well-formed piece of data and are interested in checking that that data makes sense. E.g. we may want to check that a well-formed social security number actually corresponds to a real person.

how do we validate the entities that use them? There are two options available for Java developers.

#####  Format Validation 

The first option is to add the validation into your constructors, factories and setter methods. The idea here is that it should not even be possible to put an aggregate into an inconsistent state: all required fields must be populated in the constructor, any setters of required fields will not accept null parameters, other setters will not accept values of an incorrect format or length, etc. I personally tend to use this approach when I'm working with domain models that are very rich in business logic. It makes the domain model very robust, but also practically forces you to use DTOs between clients and application services since it is more or less impossible to properly bind to a UI.

The second option is to use Java Bean Validation (JSR-303). Put annotations on all of the fields and make sure your application service runs the aggregate through the Validator before doing anything else with it. I personally tend to use this approach when I'm working with domain models that are anemic. Even though the aggregate itself does not prevent anybody from putting it into an inconsistent state, you can safely assume that all aggregates that have either been retrieved from a repository or have passed validation are consistent.

**You can also combine both options by using the first option in your domain model and Java Bean Validation for your incoming DTOs or DPOs.**

##### Content Validation 

The simplest case of content validation is to make sure that two or more interdependent attributes within the same aggregate are valid (e.g. if one attribute is set, the other must be null and vice versa). You can either implement this directly into the entity class itself or use a class-level Java Bean Validation constraint. This type of content validation will come for free while performing format validation since it uses the same mechanisms.

A more complex case of content validation would be to check that a certain value exists (or does not exist) in a lookup list somewhere. This is very much the responsibility of the application service. Before allowing any business or persistence operations to continue, the application service should perform the lookup and throw an exception if needed. This is not something you want to put into your entities since the entities are movable domain objects whereas the objects needed for the lookup are typically static.

**The most complex case of content validation would be to verify an entire aggregate against a set of business rules. In this case, the responsibility is split between the domain model and the application service. A domain service would be responsible for performing the validation itself, but the application service would be responsible for invoking the domain service.**
