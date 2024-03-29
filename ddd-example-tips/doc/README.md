## ddd-example-tips

- https://dzone.com/articles/aggregate-pattern
- https://abp.io/e9f5b0c2-e5e7-41bb-a484-7b87a88c1bba/Implementing_Domain_Driven_Design.pdf
- see https://www.jug.ch/events/slides/211019_jMolecules.pdf
See https://levelup.gitconnected.com/how-to-apply-creational-design-patterns-to-craft-flexible-software-2caa09e540ed
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


Application Services can directly work with repositories to query, create, update or delete data unless there are some domain logics should be performed during these operations. In such cases, create Domain Service methods, but only for those really necessary.




#### 


- jmolecules-architecture — annotations to express architectural styles in code.

	- jmolecules-cqrs-architecture — CQRS architecture

		- @Command

		- @CommandDispatcher

		- @CommandHandler

		- @QueryModel

	- jmolecules-layered-architecture — Layered architecture

		- @DomainLayer

		- @ApplicationLayer

		- @InfrastructureLayer

		- @InterfaceLayer

	- jmolecules-onion-architecture — Onion architecture

		- Classic

			- @DomainModelRing

			- @DomainServiceRing

			- @ApplicationServiceRing

			- @InfrastructureRing

		- Simplified (does not separate domain model and services)

			- @DomainRing

			- @ApplicationRing

			- @InfrastructureRing

	- jmolecules-hexagonal-architecture — Hexagonal architecture

		- @Application

		- @(Primary|Secondary)Adapter

		- @(Primary|Secondary)Port


### Models in Software

1.  Model Association

> model associations as much one-directional relationships as possible.  



![](association-model.avif)


```java
public class Course {
  String courseName;
  String courseCode;
  Map teachers;
  ...
}

public class Course {
  String courseName;
  String courseCode;
  Set teachers;
  ...
}
```

2. Model Entity and Value Object
   
![](entity-value-object.avif)

```java
public interface Identifier {}
public interface ValueObject {}
public interface Entity<ID extends Identifier> {}

public class StaffId implements Identifier {
    private final String StaffId;
    ...
}
public class Teacher implements Entity<StaffId> {
    private String Name;
    private Office office;
}
public class Office implements ValueObject{
    private final String faculty;
    private final String roomNumber;

    ...
    @Override
    public int hashCode() {...}

    @Override
    public boolean equals(Object o) {
        if (o == this) { return true; }
        if (o == null || o.getClass() != getClass()) { return false; }
        return faculty.equals(((Office) o).faculty) && roomNumber.equals(((Office) o).roomNumber);
    }
}
```

3. Model Services
   
![](service.avif)


4. Aggregate
   
![](DDD-8.avif)

```java
public abstract class AggregateRoot<ID extends Identifier> implements Entity<ID> {
   private final ID id;
   protected AggregateRoot(ID id) { this.id = id; }
   public ID getId() { return id; }
}

public class StudentId implements  Identifier {
   private final String id;
   public StudentId() { id = UUID.randomUUID().toString(); }
}

public class Student extends AggregateRoot<StudentId> {
   private final ModuleHistory moduleHistory;
   private final ActiveModules activeModules;
   private final Major major;

   public Student(Major major) {
       super(new StudentId());
       this.moduleHistory = new ModuleHistory();
       this.activeModules = new ActiveModules();
       this.major = major;
   }

   public StudentId getStudentId() { return getId(); }

   public void register(Module newModule){
       int currentEnrolled = activeModules.getNumOfCurrentEnrolledModules();
       int taken = moduleHistory.getNumOfModulesTaken();
       if (taken + 1 > 40) {
           throw new UnsupportedOperationException("Registered Modules have exceeded the maximum number(40) in total");
       }
       if (currentEnrolled + 1 > 6){
           throw new UnsupportedOperationException("Registered Modules have exceeded the maximum number(6) for current semester");
       }
       activeModules.register(newModule);
   }
}

public class ModuleHistory implements ValueObject {
   private final Map<String, List<Module>> moduleHistories;
   public ModuleHistory() { this.moduleHistories = new HashMap<>(); }
   public int getNumOfModulesTaken() { return moduleHistories.size(); }
}

public class ActiveModules implements ValueObject {
   private final List<Module> modules;
   public ActiveModules() { modules = new ArrayList<>(); }
   public int getNumOfCurrentEnrolledModules() { return modules.size(); }
   public void register(Module newModule) { modules.add(newModule); }
}

public class Major implements ValueObject {
   private final List<Module> coreModules;
   private final String name;
   public Major(List<Module> coreModules, String name) {
       this.coreModules = coreModules;
       this.name = name;
   }
}
```

5. Factory
   
![](DDD-9.avif)


![](DDD-10.avif)


```java
public class StudentFactory {
   private final static int DEFAULT_MAX_PER_TERM = 6;
   private final static int DEFAULT_MAX_PER_DEGREE = 40;

   public static Student create(String name, String majorName) {
       Major major = new Major(majorName);
       List<Module> coreModules = Collections.emptyList();
       major.addCoreModules(coreModules);
       Student student = new Student(name, major);
       student.addTermPolicies(MaximumModulePerTerm.ofNewPolicy(DEFAULT_MAX_PER_TERM));
       student.addDegreePolicies(MaximumModulePerDegree.ofNewPolicy(DEFAULT_MAX_PER_DEGREE));
       student.addDegreePolicies(MajorQualifiedByCoreModules.ofNewPolicy(coreModules));
       return student;
   }
}
```

![](DDD-11.avif)

```java

public interface ModulePolicy {
   public boolean isSatisfiedBy(List<Module> modules);
}
public class MaximumModulePerTerm implements ModulePolicy {
   ...
   public static MaximumModulePerTerm ofNewPolicy(int maxModulesPerTerm) {
       return new MaximumModulePerTerm(maxModulesPerTerm);
   }
   @Override
   public boolean isSatisfiedBy(List<Module> modules) {
       return modules.size() < maxModulesPerTerm;
   }
}
public class MaximumModulePerDegree implements ModulePolicy {
   ...
   public static MaximumModulePerDegree ofNewPolicy(int maxModulesPerDegree) {
       return new MaximumModulePerDegree(maxModulesPerDegree);
   }
   @Override
   public boolean isSatisfiedBy(List<Module> modules) {
       return modules.size() < maxModulesPerDegree;
   }
}

public class MajorQualifiedByCoreModules implements ModulePolicy {
   ...
   public static MajorQualifiedByCoreModules ofNewPolicy(List<Module> coreModules){
       return new MajorQualifiedByCoreModules(coreModules);
   }
   @Override
   public boolean isSatisfiedBy(List<Module> taken) {
       return taken.containsAll(coreModules);
   }
}
```

```java
public void register(Module newModule) {
   boolean isOkForCurrentTerm = termPolicies.stream().allMatch(activeModules::satisfyPolicy);
   if (!isOkForCurrentTerm)
       throw new UnsupportedOperationException("Registered Modules have exceeded the maximum number(40) in total");
   boolean isOkForDegree = degreePolicies.stream().allMatch(moduleHistory::satisfyPolicy);
   if (!isOkForDegree)
       throw new UnsupportedOperationException("Registered Modules have exceeded the maximum number(6) for current semester");
   activeModules.register(newModule);
}
```

6. Repository
   
![](DDD-12.avif)

![](DDD-14.avif)

![](DDD-13.avif)

```java
public class StudentRepository {
    public List<Student> satisfiedBy(ICriteria... criterias) {
       Optional<Condition> combined = Arrays.stream(criterias)
               .map(ICriteria::getCriteria)
               .reduce(Condition::and);
       if (!combined.isPresent()) {
           throw new UnsupportedOperationException("One criteria is needed to fetch the students.");
       }
       Select<?> selectStatements = DSL.select()
               .from(table("STUDENT"))
               .where(combined.get());
       return selectStatements.fetch().into(Student.class);
    }
    public void archive(List<StudentId> studentIds) {
        studentIds.stream()
           .map(studentId -> field("ID").eq(studentId))
           .forEach(condition -> DSL.deleteFrom(table("STUDENT")).where(condition));
    }
}

public class GraduationService {
   public List<Student> graduatingStudentByMajor(String major) {
       StudentRepository studentRepository = new StudentRepository();
       String year = "final_year";
       return studentRepository.satisfiedBy(ByMajor.of(major), ByYear.of(year));
   }
   public void graduateStudents(List<StudentId> studentIds){
       StudentRepository studentRepository = new StudentRepository();
       studentRepository.archive(studentIds);
   }
}
```

7. Side Effect Free Functions
   
This is a command (side effect method) as it updates the student's GPA. 

```java
public void completeTerm(Student student, Map<String, Integer> results) {
   ActiveModules activeModules = student.getActiveModules();
   Integer sumOfWeightedResults = activeModules.getModules()
           .stream()
           .reduce(0,
                   (subSum, module) -> subSum + results.get(module.getModuleName()) * module.getPoints(),
                   Integer::sum);
   Integer sumOfPoints = activeModules.getModules()
           .stream()
           .reduce(0,
                   (subPoints, module) -> subPoints + module.getPoints(),
                   Integer::sum);

   double gpa = ((double) sumOfWeightedResults) / sumOfPoints;
   studentRepository.updateGPA(gpa, student.getStudentId().getId());
}
```

We could refactor a little bit here to extract side effect free function:

```java
public void completeTerm(Student student, Map<String, Integer> results) {
   ActiveModules activeModules = student.getActiveModules();
   double gpa = calculateGpa(results, activeModules.getModules());
   studentRepository.updateGPA(gpa, student.getStudentId().getId());
}
public double calculateGpa(Map<String, Integer> results, List<Module> modules) {
   Integer sumOfWeightedResults = modules.stream()
           .reduce(0,
                   (subSum, module) -> subSum + results.get(module.getModuleName()) * module.getPoints(),
                   Integer::sum);
   Integer sumOfPoints = modules.stream()
           .reduce(0,
                   (subPoints, module) -> subPoints + module.getPoints(),
                   Integer::sum);

   return ((double) sumOfWeightedResults) / sumOfPoints;
}
```

 imagine if you would have to calculate the accumulated GPA which is based on the previous terms' GPA and the calculation is stateful now, we can still make use the of the side effect free function to wrap the important business logic:

```java
private double calculateAccumulatedGpa(double previousGpa, Map<String, Integer> results, List<Module> modules);
```


8. Intention Revealing Interfaces

![](DDD-15.avif)

```java
public interface ModulePolicy {}
public class MaximumModulePerTerm implements ModulePolicy {}
public class MaximumModulePerDegree implements ModulePolicy {}
public class MajorQualifiedByCoreModules implements ModulePolicy {}

```


9. Concept Contours  
10. Bounded Context

![](DDD-17.avif)


![](DDD-18.avif)


```java

package org.xudong.module;
public class ModuleBase implements Entity<ModuleCode> {
   private String moduleName;
   private String description;
   private List<String> offeringTerms;
   private ModuleCode moduleCode;

   public ModuleBase(builder br) {
       this.moduleName = br.moduleName;
       this.description = br.description;
       this.offeringTerms = br.offeringTerms;
       this.moduleCode = br.moduleCode;
   }
   public static class builder {
       private String moduleName;
       private String description;
       private List<String> offeringTerms = Collections.emptyList();
       private final ModuleCode moduleCode;
       public builder(ModuleCode moduleCode) {
           this.moduleCode = moduleCode;
       }
       public builder withModuleName(String moduleName) {
           this.moduleName = moduleName;
           return this;
       }
       public builder withDescription(String description) {
           this.description = description;
           return this;
       }
       public builder withOfferingTerm(List<String> offeringTerms) {
           this.offeringTerms = offeringTerms;
           return this;
       }
       public ModuleBase build() {
           return new ModuleBase(this);
       }
   }
}

package org.xudong.student;
public class Module implements ValueObject {
   private final ModuleBase moduleBasic;
   private final String grade;
   public Module(String moduleName, ModuleBase moduleBasic, String grade) {
       this.moduleBasic = moduleBasic;
       this.grade = grade;
   }
}

package org.xudong.teacher;

public class Module implements ValueObject {
   private final ModuleBase moduleBase;
   private final Map<StudentId, Double> grades;
   private final List<String> feedbacks;

   public Module(ModuleBase moduleBase) {
       this.moduleBase = moduleBase;
       this.grades = Collections.emptyMap();
       this.feedbacks = Collections.emptyList();
   }
}
```

11. Context Map

![](DDD-19.avif)


12. Anti-Corruption Layer

![](DDD-20.avif)


13.  