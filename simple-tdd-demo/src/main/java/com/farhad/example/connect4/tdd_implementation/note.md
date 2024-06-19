Requirement 2

Players introduce discs on the top of the columns. An introduced disc drops down the board if the column is empty. Future discs introduced in the same column will stack over the previous ones.


We can split this requirement into the following tests:

- When a disc is inserted into an empty column, its position is 0
- When a second disc is inserted into the same column, its position is 1
- When a disc is inserted into the board, the total number of discs increases
- When a disc is put outside the boundaries, a Runtime Exception is thrown
- When a disc is inserted in to a column and there's no room available for it, then a Runtime Exception is thrown


Requirement 3

It is a two-person game, so there is one colour for each player. One player uses red ('R') and the other one uses green ('G'). Players alternate turns, inserting one disc every time.


Requirement 4

We want feedback when either an event or an error occurs within the game. The output shows the status of the board on every move.

Requirement 5

When no more discs can be inserted, the game finishes and it is considered a draw.


Requirement 6

if a player inserts a disc and connects more than three discs of his color in a straight vertical line, then that player wins.

Requirement 7

If a player inserts a disc and connects more than three discs of his color in a straight horizontal line, then that player wins.

Requirement 8

If a player inserts a disc and connects more than three discs of his colour in a straight diagonal line, then that player wins.