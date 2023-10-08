## ddd-example-tips

- https://dzone.com/articles/aggregate-pattern
- https://abp.io/e9f5b0c2-e5e7-41bb-a484-7b87a88c1bba/Implementing_Domain_Driven_Design.pdf


### Domain Layer Building Blocks

- Entity
- Value object
- Aggregate & Aggregate Root
- Repository
- Domain Service
- Specification
- Domain Event

domain
	model
		cargo
			Cargo.java
			CargoRep[ository.java]
			....
		handling
			HandlingEvent.java
			HandlingEventFactory.java
			HandlingEventRepository.java
			....
		location
		voyage
	service
		RoutingService.java
	shared
		DomainEvent.java
		ValueObject.java
		Entity.java

### Application Layer Building Blocks

- Application Service
- Data Transfer Object
- Transaction	

application
	impl
		BookingServiceImpl.java
		HandlingEventServiceImpl.java
	util

	ApplicationEvent.java
	BookingService.java
	HandlingEventService.java

### The Presentation Layer

interfaces
	booking
		facade
			dto
				CargoRoutingDTO.java
				LegDTO.java
				LocationDTO.java
			internal
				assembler	
					CargoRoutingDTOAssembler.java
					ItineraryCandidateDTOAssembler.java
					LocationDTOAssembler.java
				BookingServiceFacadeImpl.java

			BookingServiceFacade.java
		web
			CargoAdminController.java
			RegistrationCommand.java
			RouteAssignmentCommand.java
	handling
		file
			UploadDirectoryScanner.java
		ws
			HandlingReportServiceImpl.java
		HandlingEventRegistrationAttempt.java
		HandlingReportParser.java
	tracking
		CargoTrackingController.java
		TrackCommand.java

### The Infrastructure  Layer

infrastructure
	messaging
		jms
			CargoHandledConsumer.java
			HandlingEventRegistrationAttemptConsumer.java
	persistence
		jpa
			CargoRepositoryJpa.java
			HandlingEventRepositoryJpa.java
	routing
		ExternalRoutingService.java


#### Business Logic in Entities Requiring External Services

- Implement the business logic on an entity method and **get external dependencies as parameters** of the method.
- Create a **Domain Service**.

#### Repositories

Common Repository principles are;

- Define a repository **interface in the Domain Layer** (because it is used in the Domain and Application Layers), **implement in the Infrastructure Layer**.
- **Do not include business logic** inside the repositories.
- Repository interface should be **database provider / ORM independent**.
- **Create repositories for aggregate roots**, not for all entities. Because, sub-collection entities (of an aggregate) should be accessed over the aggregate root.

#### Do Not Include Domain Logic in Repositories

#### Specification 

A specification is a named, reusable, combinable and testable class to filter the Domain Objects based on the business rules.

#### Domain Services

Domain Services implement domain logic which;

- Depends on **services and repositories**.
- Needs to work with **multiple aggregates**, so the logic doesn't properly fit in any of the aggregates.

Domain Services work with Domain Objects. Their methods can **get and return entities, value objects, primitive types**... etc. However, **they don't get/return DTOs**. DTOs is a part of the Application Layer.

e.g. Assigning an issue to a user 

#### Application Services

- An **Application Service** is a stateless service that implements **use cases** of the application. 
- An **application service** typically **gets and returns DTOs**. 
- It is used by the **Presentation Layer**. 
- It **uses and coordinates the domain objects** (entities, repositories, etc.) to implement the **use cases**.

Common principles of an application service are:

- Implement the **application logic** that is specific to the current use-case. Do not implement the core domain logic inside the application services.
- **Never get or return entities** for an application service method. This breaks the encapsulation of the Domain Layer. Always **get and return DTOs**.

e.g. Assigning an issue to a user 

An application service method typically has three steps those are implemented here:

1. Get the related domain objects from database to implement the use case.
2. Use domain objects (domain services, entities, etc.) to perform the actual operation.
3. Update the changed entities in the database.

#### Data transfer Objects

A **DTO** is a simple object that is used to transfer state (data) between the **Application** and **Presentation** Layers. So, **Application Service** methods **gets and returns DTOs**.

Common DTO Principles & Best Practices:

- A **DTO should be serializable**, by its nature. Because, most of the time it is transferred over network. So, it should have a **parameterless (empty) constructor**.
- Should not contain any **business logic**.
- **Never** inherit from or reference to **entities**.

**Input DTOs** (those are passed to the **Application Service** methods) have different natures than **Output DTOs** (those are returned from the **Application Service** methods). So, they will be treated differently.

**Input DTO Best Practices:**

- Do not Define Unused Properties for Input DTOs
- Do not Re-Use Input DTOs


**Output DTO Best Practices:**

- Keep output DTO count minimum. Reuse where possible (exception: Do not reuse input DTOs as output DTOs).
- Output DTOs can contain more properties than used in the client code.
- Return entity DTO from Create and Update methods. The main goals of these suggestions are;
- Make client code easy to develop and extend;
	- Dealing with similar, but not same DTOs are problematic on the client side.
	- It is common to need to other properties on the UI/client in the future. Returning all properties (by considering security and privileges) of an entity makes client code easy to improve without requiring to touch to the backend code.
	- If you are opening your API to 3rd-party clients that you don't know requirements of each client.
- Make the server side code easy to develop and extend;
	- You have less class to understand and maintain.
	- You can reuse the Entity->DTO object mapping code.
	- Returning same types from different methods make it easy and clear to create new methods.


**Object to Object Mapping**

- **Use** auto object mapping only for **Entity to output DTO** mappings.
- **Do not use** auto object mapping for **input DTO to Entity** mappings.

#### Entity Creation

Creating an object from an **Entity** / **Aggregate Root** class is the first step of the lifecycle of that entity. The **Aggregate** / **Aggregate Root** Rules & Best Practices section suggests to **create a primary constructor** for the Entity class that guarantees to **create a valid entity**. So, whenever we need to create an instance of that entity, we should always **use that constructor**.

##### Applying Domain Rules on Entity Creation

For example, assume that you **don't want** to allow to create an issue if there is already an issue with **exactly the same Title**.

**Where to implement this rule?** 

It is **not proper** to implement this rule in the **Application Service**, because it is a **core business (domain) rule** that should always be checked. This rule should be implemented in a **Domain Service**.  we need to force the **Application Layer** always to use the **Domain Service** to create a new Entity.

**Discussion: Why is the duplicate Title check not implemented in the Application Service?**

We could simply say "Because it is a **core domain logic** and should be implemented in the Domain Layer". However, it brings a new question "**How did you decide** that it is a core domain logic, but not an application logic?"

For this example, a simple question can help us to make the decision: "If we have another way (use case) of creating an issue, should we still apply the same rule? Is that rule should always be implemented". You may think "Why do we have a second way of creating an issue?". However, in real life, you have;

- **End users** of the application may create issues in your application's standard UI.
- You may have a second **back office** application that is used by your own employees and you may want to provide a way of creating issues (probably with different authorization rules in this case).
- You may have an HTTP API that is open to **3rd-party clients** and they create issues.
- You may have a **background worker** service that do something and creates issues if it detects some problems. In this way, it will create an issue without any user interaction (and probably without any standard authorization check).
- You may have a button on the UI that **converts** something (for example, a discussion) to an issue.

All of these are should be implemented by **different Application Service methods**, but they **always** follow the rule: Title of the new issue can not be same of any existing issue! That's why this logic is a **core domain logic**, should be located in the Domain Layer and **should not be duplicated** in all these application service methods.

##### Updating / Manipulating An Entity

Once an entity is created, it is updated/manipulated by the use cases until it is deleted from the system. There can be different types of the use cases directly or indirectly changes an entity.


#### Domain Logic & Application Logic

Business Logic in the Domain Driven Design is split into two parts (layers): 

- Domain Logic and 
- Application Logic

Domain Logic consists of the Core Domain Rules of the system while Application Logic implements application specific Use Cases.

##### Multiple Application Layers

DDD helps to **deal with complexity** when your system is large. Especially, if there are **multiple applications** are being developed in a **single domain**, then the **Domain Logic vs Application Logic separation** becomes much more important.

Assume that you are building a system that has multiple applications;

- A **Public Web Site Application**, built with Spring MVC, to show your products to users. Such a web site doesn't require authentication to see the products. The users login to the web site, only if they are performing some actions (like adding a product to the basket).
- A **Back Office Application**, built with Angular UI (that uses REST APIs). This application used by office workers of the company to manage the system (like editing product descriptions).
- A **Mobile Application** that has much simpler UI compared to the Public Web Site. It may communicate to the server via REST APIs or another technology (like TCP sockets).


Every application will have different **requirements**, different **use cases** (Application Service methods), different **DTOs**, different **validation** and **authorization** rules... etc.

Mixing all these logics into a single application layer makes your services contain too many if conditions with **complicated business logic** makes your code **harder to develop, maintain and test** and leads to potential bugs.

If you've multiple applications with a single domain;

- Create **separate application layers** for each application/client type and implement application specific business logic in these separate layers.
- Use a **single domain layer** to share the core domain logic.


**To be more clear about the implementation, you can create different projects for each application types.**


**Example: Creating a new Organization in a Domain Service**


- **CORRECT**: It first checks for duplicate organization name and and throws exception in this case. This is something related to core domain rule and we never allow duplicated names.
- **WRONG**: Domain Services should not perform authorization. Authorization should be done in the Application Layer.
- **WRONG**: It logs a message with including the Current User's UserName. Domain service should not be depend on the Current User. Domain Services should be usable even if there is no user in the system. Current User (Session) should be a Presentation/Application Layer related concept.
- **WRONG**: It sends an email about this new organization creation. We think this is also a use case specific business logic. You may want to create different type of emails in different use cases or don't need to send emails in some cases.

**Example: Creating a new Organization in an Application Service**

- **CORRECT**: Application Service methods should be unit of work (transactional). ABP's Unit Of Work system makes this automatic (even without need to add [UnitOfWork] attribute for the Application Services).
- **CORRECT**: Authorization should be done in the application layer. Here, it is done by using the [Authorize] attribute.
- **CORRECT**: Payment (an infrastructure service) is called to charge money for this operation (Creating an Organization is a paid service in our business).
- **CORRECT**: Application Service method is responsible to save changes to the database.
- **CORRECT**: We can send email as a notification to the system admin.
- **WRONG**: Do not return entities from the Application Services. Return a DTO instead.

**Discussion: Why don't we move the payment logic into the domain service?**

You may wonder why the payment code is not inside the `OrganizationManager`. It is an **important thing** and we never want to **miss the payment**.

However, **being important is not sufficient** to consider a code as a Core Business Logic. We may have **other use cases** where we don't charge money to create a new Organization. Examples;

- An admin user can use a Back Office Application to create a new organization without any payment.
- A background-working data import/integration/synchronization system may also need to create organizations without any payment operation.

As you see, **payment is not a necessary operation to create a valid organization**. It is a use-case specific application logic.


Example: CRUD Operations


- **Do not** create Domain Service methods just for simple CRUD operations **without any domain logic**.
- **Never** pass **DTOs** to or return **DTOs** from the Domain Services.