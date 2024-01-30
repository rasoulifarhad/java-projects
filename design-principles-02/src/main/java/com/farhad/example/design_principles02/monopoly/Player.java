package com.farhad.example.design_principles02.monopoly;

import java.util.List;

import lombok.Data;

@Data
public class Player {

	private String name;
	private List<Piece> ownes;
	private Square location;
	
	public void takeTurn() {
		
	}
}
