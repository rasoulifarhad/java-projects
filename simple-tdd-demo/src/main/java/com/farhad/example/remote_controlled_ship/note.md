Imagine that a naval ship is placed somewhere on Earth's seas. Since this is the 21st century, we can control that ship remotely.

Our job will be to create a program that can move the ship around the seas.

The Problem

A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth.

A rover's position and location is represented by a combination of x and y co-ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.

In order to control a rover, NASA sends a simple string of letters. The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or right respectively, without moving from its current spot. 'M' means move forward one grid point, and maintain the same heading.

Assume that the square directly North from (x, y) is (x, y+1).

The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0. The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover's position, and the second line is a series of instructions telling the rover how to explore the plateau.

The position is made up of two integers and a letter separated by spaces, corresponding to the x and y coordinates and the rover's orientation.

Each rover will be finished sequentially, which means that the second rover won't start to move until the first one has finished moving.

The output for each rover should be its final coordinates and heading.

Input:
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM

Output:
1 3 N
5 1 E


Requirement 1

You are given the initial starting point (x, y) of a ship and the direction (N, S, E, or W) it is facing.

Requirement 2


Implement commands that move the ship forward and backward (f and b).

Requirement 3

Implement commands that turn the ship left and right (l and r).

Requirement 4

The ship can receive a string with commands (lrfb is equivalent to left, right, forward, and backward).

Requirement 5


Implement wrapping from one edge of the grid to another.

Requirement 6

Implement surface detection before each move to a new position. If a command encounters a surface, the ship aborts the move, stays on the current position, and reports the obstacle.
