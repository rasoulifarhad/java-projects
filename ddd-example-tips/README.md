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