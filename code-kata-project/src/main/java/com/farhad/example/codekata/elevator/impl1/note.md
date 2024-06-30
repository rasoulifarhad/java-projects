the basic requirements for this problem are:

- The elevator can go up and down in a real-world fashion.
- Users can send requests to the elevator from both outside and inside the elevator.

The first requirement is a bit vague, so let me break it down. A real-world elevator has the following behaviours:

- When elevator is going up or down, it will stop at all the floors that the users requested.
- If the elevator received a request of going down while it is going up, the elevator will go to the highest floor in the current requests, and then go down.
- Users can send requests at anytime.


Assumptions

Now, in real life, the elevator will finish all up requests before starting down requests. Let’s assume that going up has more priority than going down, which means that when the elevator is in IDLE state, and has both up and down requests, it will execute up requests first.

When, the requester is outside of the elevator, the elevator needs to stop at the currentFloor of the requester, before going to the desiredFloor of the requester.