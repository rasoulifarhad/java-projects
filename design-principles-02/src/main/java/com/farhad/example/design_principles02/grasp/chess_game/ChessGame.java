
package com.farhad.example.design_principles02.grasp.chess_game;

import java.util.List;

import lombok.Data;

@Data
public class ChessGame {

	
	private Player whitPlayer;
	private Player blackPlayer;

	// played using
	private List<Piece> pieces;
}
