Requirement 1

A piece can be placed on any empty space of a 3×3 board.

We can split this requirement into three tests:

- When a piece is placed anywhere outside the X axis, then RuntimeException is thrown.
- When a piece is placed anywhere outside the Y axis, then RuntimeException is thrown.
- When a piece is placed on an occupied space, then RuntimeException is thrown.

Requirement 2

There should be a way to find out which player should play next.


We can split this requirement into three tests:

- The first turn should be played by played X
- If the last turn was played by X , then the next turn should be played by O
- If the last turn was played by O , then the next turn should be played by X

Requirement 3

A player wins by being the first to connect a line of friendly pieces from one side or corner of the board to the other.

- If no winning condition is fulfilled, then there is no winner.
- The player wins when the whole horizontal line is occupied by his pieces.
- The player wins when the whole vertical line is occupied by his pieces.
- The player wins when the whole diagonal line from the top-left to bottom-right is occupied by his pieces.
- The player wins when the whole diagonal line from the bottom-left to top-right is occupied by his pieces

Requirement 4 

The result is a draw when all the boxes are filled.