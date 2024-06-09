Requirement 1

A piece can be placed on any empty space of a 3×3 board.

We can split this requirement into three tests:

- When a piece is placed anywhere outside the X axis, then RuntimeException is thrown.
- When a piece is placed anywhere outside the Y axis, then RuntimeException is thrown.
- When a piece is placed on an occupied space, then RuntimeException is thrown.