This is a summary of the behavior of the rover:

- It's located on a grid at some point with coordinates (x,y) and facing a direction encoded with a character.

- The meaning of each direction character is:
    - N -> North
    - S -> South
    - E -> East
    - W -> West

- The rover receives a sequence of commands (a string of characters) which are codified in the following way:
    - When it receives an f, it moves forward one position in the direction it is facing.
    - When it receives a b, it moves backward one position in the direction it is facing.
    - When it receives a l, it turns left changing its direction (by one step in the direction).
    - When it receives a r, it turns right changing its direction (by one step in the direction).


See https://github.com/Codesai/practice_program
