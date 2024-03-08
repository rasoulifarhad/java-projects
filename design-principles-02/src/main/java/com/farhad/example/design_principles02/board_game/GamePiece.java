package com.farhad.example.design_principles02.board_game;

// You know that every GamePiece object must be able to move().You simply have no idea how it should go about doing it!
//
// Obviously, a Checker has very different moves than a Bishop, and a Bishop has different move than a Knight or a Rook.
//
// The declaration of the move() method in the GamePiece class is thus a stipulation that all subclasses inherit the move() 
// specification, but no associated implementation.
public abstract class GamePiece {

	public abstract void move();

}
