package com.farhad.example.adapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Captain {
	private final RowingBoat rowingBoat;

	public void row() {
		rowingBoat.row();
	}
}
