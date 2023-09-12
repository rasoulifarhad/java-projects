package com.farhad.example.adapter;

public class EscapePirates {
	public static void main(String[] args) {
		Captain captain = new Captain(new FishingBoatadapter());
		captain.row();
	}
}
