Requirement 2

Players introduce discs on the top of the columns. An introduced disc drops down the board if the column is empty. Future discs introduced in the same column will stack over the previous ones.


We can split this requirement into the following tests:

- When a disc is inserted into an empty column, its position is 0
- When a second disc is inserted into the same column, its position is 1
- When a disc is inserted into the board, the total number of discs increases
- When a disc is put outside the boundaries, a Runtime Exception is thrown
- When a disc is inserted in to a column and there's no room available for it, then a Runtime Exception is thrown