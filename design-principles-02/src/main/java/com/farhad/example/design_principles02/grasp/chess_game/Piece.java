package com.farhad.example.design_principles02.grasp.chess_game;

// e.g. Pawn, Rook, Queen, ..
// 32
public class Piece {

	// owns
	private PossibleMoves possibleMoves;

	// played on
	private ChessBoard chessBoard;

	public void move() {
		
	}
	public PossibleMoves getAllMoves() {
		return null;
	}
}
