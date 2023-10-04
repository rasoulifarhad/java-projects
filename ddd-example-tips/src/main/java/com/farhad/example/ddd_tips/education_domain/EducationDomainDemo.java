package com.farhad.example.ddd_tips.education_domain;

/**
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
 */                        
public class EducationDomainDemo {
    
}
