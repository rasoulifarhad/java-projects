The Lift Kata

Since lifts are everywhere and they contain software, how easy would it be to write a basic one? Let’s TDD a lift, starting with simple behaviors and working toward complex ones. Assume good input from calling code and concentrate on the main flow.

Here are some suggested lift features:

- a lift responds to calls containing a source floor and direction
- a lift has an attribute floor, which describes it’s current location
- a lift delivers passengers to requested floors
- you may implement current floor monitor
- you may implement direction arrows
- you may implement doors (opening and closing)
- you may implement DING!
- there can be more than one lift

See https://kata-log.rocks/lift-kata
See https://github.com/swkBerlin/kata-bootstraps

Advanced Requirements

- a lift does not respond immediately. consider options to simulate time, possibly a tick method.
- lift calls are queued, and executed only as the lift passes a floor

Objects Only

Can you write a lift that does not need to be queried? Try writing a lift that only sends messages to other objects.



     

Lift Kata Description

Since lifts are everywhere and they contain software, how easy would it be to write a basic one? Let’s TDD a lift, starting with simple behaviors and working toward complex ones. Assume good input from calling code and concentrate on the main flow.

Lift features:

- a lift moves between a number of floors.
- a lift has a panel of buttons passengers can press to request floors.
- people can call the lift from other floors. A call has both a floor and a desired direction.
- a lift has doors which may be open or closed.

In this repository, that much is already implemented. The following features are not yet implemented:

- a lift fulfills a request when it moves to the requested floor and opens the doors.
- a lift fulfills a call when it moves to the correct floor, is about to go in the called direction, and opens the doors.
- a lift can only move between floors if the doors are closed.

Lifts do not respond immediately or do everything at once. To simplify handling time in this exercise, the provided LiftSystem class has a 'tick' method. Every time you call it, the lift system should simulate a unit of time passing, and update its state according to what changes occurred during that time period. Lifts can move between floors or open their doors for example.

To simplify things, Lifts only accept new calls and requests when they are on a floor. (Then we don't have to model what happens when they are between floors).

The starting code has a Lift class with basic attributes like a floor, requests and doors. Can you build on this code and create something that fulfills all the desired features? Consider Object-Oriented design principles. Can you make Lift and LiftSystem into a well-designed encapsulated objects?



See https://github.com/emilybache/Lift-Kata
