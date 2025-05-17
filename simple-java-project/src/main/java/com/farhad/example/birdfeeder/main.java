package com.farhad.example.birdfeeder;

// Recall that a user story usually takes the form: 
// “As a <role>, I want to <action>, in order to <benefit>.”
//
// “As Alice, the owner, I want to open and close the bird feeder 
// doors with a remote control, in order to keep the predator 
// birds away from the feeder.”
//
// From this user story we can generate a scenario that fleshes out what Alice 
// wants to do, which might look like this: “Alice is sitting at her kitchen 
// table having her morning coffee. doors opened when the sun came out this morning 
// and the feeder has attracted several songbirds. As Alice is watching the songbirds, 
// a couple of blue jays arrive, chase the songbirds off, and begin feasting on the 
// birdseed. Alice reaches for the remote control and presses the button. The bird 
// feeder doors close smoothly and the blue jays fly off. Alice presses the remote 
// control button again and the doors open. After a while the songbirds return and 
// Alice can finish her coffee.”
//
// Our previous use case looked like this:
// 1. The sensor detects sunlight at a 40% brightness level.
// 2. The feeding doors open.
// 3. The birds arrive, eat, and drink.
// 4. The birds leave.
// 5. The sensor detects a decrease in sunlight to a 25% brightness level.
// 6. The feeding doors close
// 
// A remote control use case:
// 1. Alice hears or sees birds at the bird feeder.
// 2. Alice determines that they are not songbirds.
// 3. Alice presses the remote control button.
// . The feeding doors close.
// 5. The birds give up and fly away.
// 6. Alice presses the remote control button.
// 7. The feeding doors open again.
//
// The new RemoteControl class
//
// The new requirement is that “The B++ must be able to detect the unwanted 
// birds and close the doors automatically.”
// 
// It seems we have at least a couple of things to decide:
// 1. How does the bird feeder detect the birds?
// 2. How do we distinguish between the unwanted birds and the songbirds?
// 3. When does the bird feeder open the doors again after they’ve been closed?
//
// Let’s do a use case. Because opening and closing the feeding doors with the 
// song identifier is a lot like using the remote control, let’s start with the 
// RemoteControl use case and add to it:
// 
// Main Path
// 1. Alice hears or sees birds at the bird feeder.
// 2. Alice determines that they are not songbirds.
// 3. Alice presses the remote control button.
// 4. The feeding doors close.
// 5. The birds give up and fly away.
// 6. Alice presses the remote control button.
// 7. The feeding doors open again.
//
//   Alternate Path
//   1.1 The songbird identifier hears birdsong.
//   2.1 The songbird identifier recognizes the song as from an unwanted bird.
//   3.1 The songbird identifier sends a message to the feeding doors to close.
//   5.1 The songbird identifier hears birdsong.
//   5.2 The songbird identifier recognizes the song as from a songbird.
//   6.1 The songbird identifier sends a message to the feeding doors to open.
//
// Here are some steps to finding candidate objects in your system:
//
// 1. Write a set of use cases: These will describe how the application will work for
//    a number of different scenarios. Remember, each use case must have a goal.
//    Alternate paths through a use case may indicate new requirements that require a
//    new use case.
//
// 2. Identify the actors: Identify the actors in each use case, the operations they need
//    to perform, and the other things they need to use in performing their actions.
//
// 3. Name and describe each candidate object: Base the identification on tangible
//    things in the application domain (like nouns). Use a behavioral approach and
//    identify objects based on what participates in what behavior (use verbs).
//
// Objects can manifest themselves in a number of ways. They can be
// • External entities that produce or consume information
// • Things that are part of the information domain (reports, displays, and the like)
// • Occurrences or events that occur within the system
// • Internal producers (objects that make something)
// • Internal consumers (objects that consume what producers make)
// • Places (remote systems, databases, and so on)
// • Structures (windows, frames)
// • People or characteristics of people (person, student, teacher, and so on)
// • Things that are owned or used by other objects (like bank accounts or
//   automobile parts).
// • Things that are lists of other objects (like parts lists, any kind of collection, and
//   so on)
// 
// 4. Organize the candidate objects into groups: Each group represents a cluster of
//    objects that work together to solve a common problem in your application. Each
//    object will have several characteristics:
// • Required information: The object has information that must be remembered so
//   the system can function.
// • Needed services: The object must provide services relating to the system goals.
// • Common attributes: The attributes defined for the object must be common to all
//   instances of the object.
// • Common operations: The operations defined for the object must be common to
//   all instances of the object.
//
// 5. Make sure the groups you’ve created represent good abstractions for objects and
//    work in the application: Good abstractions will help make your application easier
//    to re-work when you inevitably need to change some feature or relationship in
//    the application.
//
public class main {

}
