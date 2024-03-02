package com.farhad.example.design_principles02.meeting_scheduling_system;

// From Object-Oriented Design in Java book
//
// Day 1: The System Concept
//
// The program we’re going to build,” Dawn continues, “is a scheduling system that will 
// allow our workers to quickly and easily schedule meetings with other individuals and 
// groups.It will be deployed over our organizational intranet and,if some security issues 
// can be worked out,will be available on the Internet as well.Then you’ll be able to schedule
//  meetings or check and update your schedule from anywhere in the world.Even in its first 
// incarnation,we expect that the program can do a lot to make it easier for our workers to 
// communicate.
//
// Meeting Scheduling System: Problem Summary Statement
//
// The meeting scheduling system lets workers specify their schedules and lets them organize meetings 
// with others,based on mutual availability.The system also tracks company holidays,preventing workers 
// from attempting to schedule a meeting when no one is likely to be available.
//
// Then, thinking about work schedules, you realize that many people have the same,or nearly the same,work 
// schedule from week to week.It would be helpful if the system allowed users to enter a standard schedule.
// Then they could make adjustments for just those days that fail to fit the standard schedule.
//
// Thinking how awkward it can be to have a computer prevent you from doing something you want to do,you 
// revise the statement slightly,changing the part about preventing to informing.
//
// Day 2: Preparing CRC Cards
//
// Meeting Scheduling System: Problem Summary Statement
//
// The meeting scheduling system lets workers specify their schedules and lets them organize meetings 
// with others,based on mutual availability.The system also tracks company holidays,informing workers 
// who attempting to schedule a meeting when no one is likely to be available.
// The system allows a user to enter a standard work schedule. The schedule for a given week is based 
// on this standard schedule,but the user can modify it as needed to handle schedule differences that 
// arise from week to week.
//
// None Phrases         Verb Phrases
// ------------         ------------
// Worker              Specify schedule
// Schedule            Organize meeting
// Meeting             Enter standard schedule
// Holidsy             Enter schedule modification
// Standard schedule
// Schedule modification
//
// Participant: A worker who is scheduled to attend a meeting
//
// Meeting: A group of workers who come together at a set time and place and work together for a set interval   
//
// Holiday: An interval during which, by company policy, no one is available for meetings
// 
// Every meeting occurs someplace—an office or a conference room
// Location: A place where a meeting is to be held.
//
// We need a class to represent the user interface and another to represent the database back end.
//
// User: the worker interacting with the system.
//
// Now, starting with the Participant class, you take the classes one by one, inviting team members 
// to identify the data attributes of each class.
// You encourage the team to call out attributes without arguing about whether a given attribute is 
// needed.
//
// When a minute or so has passed without anyone proposing a new attribute, you find the team has 
// arrived at the following list of candidate attributes for Participant:	
// 
// - name
// - employee number
// - office location
// - telephone number
// - email address
// - birth date
// - schedule
//
// after some time:
//
// Class          Attributes
// ------         -----------
// Participant    Employee number
//                telephone number
//                email address
//                name
//                schedule
//
// Meeting        meeting name
//                schedule
//                location
//                participants
//
// User           Employee number
// 
// Location       room number
//                capacity
//                schedule
//
// Holiday        haliday name
//                schedule
//
// Day 3: Called on Account of Dawn
//
// Day 4: Drawing Collaboration Diagrams
// 
// What we’d like to do today,” you begin, while distributing the CRC cards around the table,“is work on 
// responsibilities and collaborations.To do that,we’re going to do a little play acting.Each of you take 
// a single card,which represents one of the classes we already defined.If you think you don’t know 
// anything about how that class should work, feel free to exchange it with someone else.
// 
// EXPLORING USE CASES
//
// One function you’ve defined for the system is to schedule a meeting between participants.
//
// anybody who’s authorized could set up a meeting. Perhaps nTarzan’s secretary.The user doesn’t need to be 
// any particular person.
// 
//   /----- 4:hookMeeting() -------------
//  |                                   |
//  |                                   V
// user --- 1:getFreeTimes() ---> firstParticipant
//  |
//  |                                    
//   \----- 5:hookMeeting() ---------------
//  |                                   | 
//  |                                   V
//  \------ 2:getFreeTimes() ----> secondParticipant
//  |
//  | 
//  \------- 6s:hookMeeting() -----------
//  |                                  |
//  |                                  V
//  \------ 3:getLocation() ------> location
//
// ASSIGNING RESPONSIBILITIES
//
// Now, we need to transfer the responsibilities we’ve just identified to the CRC cards,” you say.“Each of 
// you that’s holding a card from this scenario,put each of your class’s responsibilities in the left 
// column and the related collaborator opposite it,in the right column.
// 
// Participant:
//
// Responsibility: getFreeTimes(), hookMeetings()
//
// Location:
//
// Responsibility: getLocations(), hookMeetings()
//
// User:
//
// Responsibility: setMeeting()        Participant. Location
//
// ALTERNATIVE SCENARIOS 	
//
//
// user --- 1:getFreeTimes() ---> firstParticipant
//  |                                   
//  \------ 2:getFreeTimes() ----> secondParticipant
//  |
//  \------ 3:isHoliday() ------> holiday
//
// Holiday:
//
// Responsibility: isHoliday()
//
//
// What happens when a user wants to cancel a meeting—say,Tarzan’s meeting with Cheetah?
// 
// user --- 1:cancleMeeting() ---> firstParticipant
//  |                                   
//  \------ 2:cancleMeeting() ----> secondParticipant
//  |
//  \------ 3:cancleMeeting() ------> location
//
// FINDING WHO’S WHO
//
// How do you know who the participants in the meeting are? Who is it that you send the 
// cancelMeeting()message to?
//
// If I know the time and location of the meeting,I could ask Participant to tell me who’s booked for it. 
//
// the Meeting class, which could hold a list of meeting participants.Then you wouldn’t have to ask 
// Participant at all.
//
// So, what does the cancellation scenario look like? It seems we need to add a responsibility to 
// Participant in order to make everything work right. 
//
//   /----- 1:getMeetingParicipants() ---> participant
//  |
// user --- 2:cancleMeeting() ---> firstParticipant
//  |                                   
//  \------ 3:cancleMeeting() ----> secondParticipant
//  |
//  \------ 4:cancleMeeting() ------> location
//
// Participant:
//
// Responsibility: getFreeTimes(), hookMeetings(), getMeetingParticipants()
//
//
// SCHEDULE MATTERS
//
// Let’s look now at the way a user establishes his or her schedule within the system.
// Well, there are two aspects to this. One involves initially establishing a schedule.The other involves 
// tweaking the schedule as,from time to time,you find out you’re going to be away from the office or 
// whatever.
//
// What happens when I want to enter my schedule for next week?
// 
// user --- 1:addFreeTime() ---> participant
// 
// Okay, what about blocking out time that won’t be available?
//
// I simply need another responsibility, call it subtractFreeTime(),that blocks out the specified time block.
//
//
// Participant:
//
// Responsibility: getFreeTimes(), hookMeetings(), getMeetingParticipants(), addFreeTime(), subtractFreeTime()
//
// is how the schedules are stored.I mean,the Participant class and the Location class each have a schedule 
// attribute.Shouldn’ t it be an object of some sort?
// 
// Let’s create a CRC card for a Schedule class. How about we represent the time-related part of the schedule as 
// a set of ordered pairs:a begin time and an end time.Each member of the set can also specify a location or a 
// code that means‘free’to handle the meeting-related part.
//
// Schedule:
//
// Responsibility: isFree(), locationAtTime();
//
// Attributes: beginTime, endTime, location
//
// What about my Meeting class? Is it not needed after all?
//
// Before you can determine the responsibilities of a class, you need to know what users expect the system to do.The 
// easiest way to do that is by working through use-case scenarios.A scenario is developed by asking,“What happens 
// when the user does this?”Remember,you’re not interested in determining what actually happens at the technical 
// level—that is,which records are deleted or which database tables affected.Instead,you’re interested in describing 
// system interactions from the user’s point of view:“If I withdraw money from my bank account,the ATM machine gives 
// me some money and a receipt,and my bank balance is reduced.”
//
// Day 5: The End in Sight
//
// Class         attributes          method
// -----         ----------          ------
// User          employeeNumber      setMeeting()
//                                   cancelMeeting()
//                                   addFreeTime()
//                                   subtractFreeTime()
//
// Participant   employeeNumber      getFreeTime()
//               name                bookMeeting()
//               telephoneNumber     getMeetingParticipants()
//               emilAddress         addFreeTime()
//               schrdule            subtractFreeTime() 
//
// Location      roomNumber          getLocation()
//               capacity            bookMeeting()
//               schedule
//
// Holiday       holidayName         isHoliday()
//               schedule
//
// Schedule      beginTime           isFree()
//               endTime             locationAtTime()
//               location
//
// INTERFACE AND PROTOTYPE
// 
//     Meeting title: 
//          Location:
//      Participants:
//
// Begin Hour/Minute:
//   End Hour/Minute:
//              Date:
//
//
// Day 6: Demonstrating the Prototype
//
// RELATIONSHIP HEURISTICS
//
// Rules that help you decide which kind of relationship will be most effective
// Rules that help you implement a particular relationship most effectively
//
// - Don’t put all your eggs in one basket.
// - 
//
// Kinds of Associations
// 
// Objects can work together in three different ways:
// - An object can use another object to do some work.This is called an association,acquaintance,or uses 
//   relationship.
// - A complex object may be composed of several simpler parts.This is called a composition relationship,although 
//   sometimes it’s also called aggregation or containment relationship.
// - When two objects depend on each other but don’t directly interact,a simple or weak association is formed.
//
// How Many? A Cardinal Question
// 
// - How many objects will participate in the association?
// - Is the association mandatory or optional?
//
// a SalesInvoice object:
//
// Invoice
//
// Sold To                                     Ship To
// ----------------------------------------------------
// Name:                                       Name: 
// Address 1:                                  Address 1:
// Address 2:                                  Address 1:
// City, State, Zip                            City, State, Zip	
// Sold by:                                    Date:
//
// Item     Qty    Description           Price      Total
// ------------------------------------------------------
//
//
//
//                                            Sum:
//                                      Sales Tax:
//                                      Total Due:
//
// Object         Description
// ------         -----------
// Customer       Purchased the product
// recipirnt      Ship the product here
// SalesPerson    Who took the order
// LineItems      The things purchased

public class App {

}
