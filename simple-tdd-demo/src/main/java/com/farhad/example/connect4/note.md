Connect4 is a two-player connection game, in which the players first
choose a color and then take turns dropping colored discs from the top
into a seven-column, six-row, vertically suspended grid. The pieces fall
straight down, occupying the next available space within the column. The
objective of the game is to connect four of one's own discs of the same
color next to each other vertically, horizontally, or diagonally, before your
opponent connects four of theirs.

### Requirements

1. The board is composed of seven columns and six rows, all positions are emptys.

2. Players introduce discs on the top of the columns. The introduced disc drops down the board if the column is empty. Future discs introduced in the same column will stack over the previous ones.

3. It is a two-person game, so there is one color for each player. One player uses red ('R') and the other one uses green ('G'). Players alternate turns, inserting one disc every time.

4. We want feedback when either an event or an error occurs within the game. The output shows the status of the board after every move.

5. When no more discs can be inserted, the game finishes, and it is considered a draw.

6. If a player inserts a disc and connects more than three discs of his color in a straight vertical line, then that player wins.

7. The same happens in a horizontal line direction.

8. The same happens in a diagonal line direction.