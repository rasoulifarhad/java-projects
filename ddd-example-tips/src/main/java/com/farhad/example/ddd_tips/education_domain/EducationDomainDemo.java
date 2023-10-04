package com.farhad.example.ddd_tips.education_domain;

/**
 * 
 * Education domain
 * 1. A course can not accept more than N students.
 * 2. N, the course capacity, can change any time to any positive integerdifferent 
 *    from the current one.(even if the number of currently subscribed students is 
 *    larger than the new value)
 * 
 * Events: Course Created Event, Student Subscribed to Course Event, 
 *         Student Unsubscribed from Course Event, Course Capacity Changed Event
 * 
 * Commands: Create Course Command, Subscribe Student to Course Command,
 *           Unsubscribe Student from Course Command, Update Course Capacity Command
 * 
 * The nouns become our aggregates. <<Course>>
 * 
 * Course aggregate:
 *       +--------+       +--------------+                 
 *       |        |      *|              | Subscribe Student to Course Command
 *       | Course |------>| Subscription |  Unsubscribe Student from Course Command
 *       |        |       |              |
 *       +--------+       +--------------+
 *       Update Course Capacity Command
 * 
 * Event sourced COURSE aggregate
 *           
 *            Course Created Event
 *            Course Capacity Changed Event
 * 
 *            Student Subscribed to Course Event
 *            Student Unsubscribed from Course Event
 * 
 * Education domain
 * 1. A course can not accept more than N students.
 * 2. N, the course capacity, can change any time to any positive integerdifferent 
 *    from the current one.(even if the number of currently subscribed students is 
 *    larger than the new value)
 * 3. The course title can change any time to any title different from the current one.
 * 
 *    Events:  Course Renamed Event
 *    Command: Rename Course Command
 * 
 * The boundary of consistency is also the boundary of concurrency
 * 
 *  Concurrent command execution 
 * 
 *                          +--------+       +--------------+
 *      Update Course       |        |      *|              |----------\
 *      Capacity Command    | Course |------>| Subscription |          |   DB
 *                          |        |       |              |       ___V______
 *                          +--------+       +--------------+      ()_________)
 *                          +--------+       +--------------+           ^ 
 *      Rename Course       |        |      *|              |           |
 *      Command             | Course |------>| Subscription |           |
 *                          |        |       |              |--------X-/
 *                          +--------+       +--------------+
 * 
 * Alternative solution
 * 
 * Course Subscription aggregate:
 *       +--------------------+       +--------------+
 *       | <<Aggregate Root>> |      *|              | 
 *       |      Course        |------>| Subscription | 
 *       |    Subscription    |       |              |
 *       +--------------------+       +--------------+
 * 
 * CourseInfo aggregate:
 *       +--------------------+
 *       | <<Aggregate Root>> |
 *       |      Course        |
 *       |       Info         |
 *       +--------------------+ 
 * 
 * What if model changes...
 * 
 * - State Persisted Aggregates
 * 
 *     - Script
 * 
 * - Event Sources Aggregates
 * 
 *                         /--> Course Subscription Created
 *    - Course Created -->| 
 *                         \--> Course Info Created
 * 
 *   - Course Renamed --> Course Renamed
 * 
 *   - Course Capacity Changed --> Course Capacity Changed
 * 
 * Education domain
 * 1. A course can not accept more than N students.
 * 2. N, the course capacity, can change any time to any positive integerdifferent 
 *    from the current one.(even if the number of currently subscribed students is 
 *    larger than the new value)
 * 3. The course title can change any time to any title different from the current one.
 * 4. The student cannot join more than 10 courses 
 * 
 *   Events:  Student Created Event
 *   Command: Create Student Command
 * 
 *   Subscribe Student to Course Command, Unsubscribe Student from Course Command
 * 
 *   Student Subscribed to Course Event, Student Unsubscribed from Course Event
 * 
 * The nouns become our aggregates. <<Student>>
 * 
 * The STUDENT aggregate 
 *       +---------+       +--------------+                 
 *       |         |      *|              |  Subscribe Student to Course Command
 *       | Student |------>| Subscription |  Unsubscribe Student from Course Command
 *       |         |       |              |
 *       +---------+       +--------------+
 * 
 * we need  some of synchronization:
 * 
 *  +------------------------+   
 *  | Saga                   |         +-------------------+ +--------------------+
 *  |  +-------------------+ |     (1) | Subscribe Student | | Student Subscribed |
 *  |  | Subscribe Student | | /------>|         to        | |         to         |
 *  |  |       to          | | |       |   Course Command  | |     Course Event   |
 *  |  | Course Command    |----       +-------------------+ +--------------------+  
 *  |  +-------------------+ | |                       | Student |
 *  |                        | |                       +---------/
 *  |                        | |
 *  |                        | |
 *  |                        | |       +-------------------+ +--------------------+
 *  |                        | |       | Subscribe Student | | Student Subscribed |
 *  |                        | \------>|         to        | |         to         |
 *  |                        |     (1) |   Course Command  | |     Course Event   |
 *  |                        |         +-------------------+ +--------------------+ 
 *  |                        |                          | Course |
 *  +------------------------+                          +--------/
 * 
 *                                                  if Course failde and 
 *                                                  subscribe event not 
 *                                                  fired.  
 * 
 *   <img src="./doc-files/saga-01.png"/>
 * 
 *  It's just a long transaction... 
 * 
 *  Long transaction are very common when the business rule spans bounded contexts. 
 * 
 * But when the rule spans multiple aggregates in the same bounded context? 
 * Is this a necessary complexity or it can be avoided? 
 * 
 * Focus on Behavior...
 * 
 * Let restart from story telling... 
 * 
 *     +---------+ +----------+ +-------+ 
 *     |         | |          | |       | 
 *     | Command | | Decision | | Event | ........
 *     |         | |          | |       | 
 *     +---------+ +----------+ +-------+ 
 * 
 * Focus on Decision...
 * 
 *    Decision block = Message handler
 * The message handler knows what it needs to make a decision
 * 
 * 
 * Event sourcing 
 * 
 * Event sourcing provides a huge advantage because it decouples the persistence from the 
 * model needed for taking the decision 
 * 
 * The message handler can build on the ﬂy any model 
 * needed for taking the decision starting from the correct event stream
 * 
 *  <img src="./doc-files/saga-02.png"/>
 * 
 * 
 * Event Store 
 *    
 *      events = stream(AggregateIdentiﬁer id) NOOOOOOO
 * 
 *      events = stream(StreamQuery query)    OKKKKKKK
 * 
 *  <img src="./doc-files/saga-03.png"/>
 * 
 * The focus is on the Message Handler 
 * 
 *  - Less waste of resources 
 *  - No upfront modelling required 
 *  - More ﬂexibility 
 * 
 *  <img src="./doc-files/saga-04.png"/>
 * 
 *  <img src="./doc-files/saga-05.png"/>
 * 
 * Event Store 
 * 
 *   - append(Event[] events) 
 *   - append(Event[] events, StreamQuery query, EventIdentiﬁer lastEvent) 
 * 
 *  Conditional append 
 * 
 *   if (lastEventIdentifier(query) != lastEvent) { 
 * 
 *        rejectAppend(); 
 *   } 
 * 
 * Warranty of consistency 
 * 
 *   - The event(s) are appended only if the there is no other event matching the query 
 *     that has appended after the lastEvent 
 * 
 * 
 *  <img src="./doc-files/saga-06.png"/>
 * 
 * 
 *  <img src="./doc-files/saga-07.png"/>
 * 
 *  <img src="./doc-files/saga-08.png"/>
 * 
saga-11 * 
 * Limited contention 
 * 
 *   - Before the contention boundaries were those of the aggregate... 
 *   - Now, the contention boundaries are those of the stream query 
 * 
 *  <img src="./doc-files/saga-09.png"/>
 * 
 * 
 *  <img src="./doc-files/saga-10.png"/>
 * 
 *  <img src="./doc-files/saga-11.png"/>
 * 
 *  <img src="./doc-files/saga-12.png"/>
 * 
 *  <img src="./doc-files/saga-13.png"/>
 * 
 *  <img src="./doc-files/saga-14.png"/>
 * 
 *  <img src="./doc-files/saga-15.png"/>
 * 
 * 
 * Append Events with Domain Identiﬁers 
 * 
 *   - append(DomainEvent[] events) 
 *   - append(DomainEvent[] events, StreamQuery query, EventIdentiﬁer lastEvent) 
 * 
 *  Domain Event 
 * 
 *      DomainEvent { 
 *          Event event, 
 *          DomainIdentiﬁers[] identiﬁers 
 *      } 
 * 
 * 
 * Domain Identiﬁer 
 * 
 *    - KEY: VALUE 
 *          KEY: The concept in the domain 
 *          VALUE: The unique instance identiﬁer 
 * 
 *     This is just an example, 
 *     They can be anything, as far as they are unique inside the bounded context 
 * 
 *  <img src="./doc-files/saga-16.png"/>
 * 
 *  <img src="./doc-files/saga-17.png"/>
 * 
 * 
 *  Pure events 
 * 
 *      - An event does NOT belong to an aggregate 
 *      - An event is just a description of a fact that is important for the business 
 *      - An event can be related to one or multiple domain concepts addressed by their Domain Identiﬁers 
 * 
 *  Less complexity 
 *     
 *      - No owner of the event 
 *      - The business decision can easily involve several domain concepts 
 *      - The decision is taken in one place 
 * 
 * See https://www.slideshare.net/saratry/the-aggregate-is-dead-long-live-the-aggregate-springiopdf
 */       

public class EducationDomainDemo {
    
}
