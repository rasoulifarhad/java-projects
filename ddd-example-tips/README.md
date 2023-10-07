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
