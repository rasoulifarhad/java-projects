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
