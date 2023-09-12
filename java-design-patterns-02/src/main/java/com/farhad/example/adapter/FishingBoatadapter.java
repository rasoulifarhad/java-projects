package com.farhad.example.adapter;

public class FishingBoatadapter implements RowingBoat {

	private final FishingBoat fishingBoat;

	public FishingBoatadapter() {
		fishingBoat = new FishingBoat();
	} 
	
	@Override
	public void row() {
		fishingBoat.sail();
	}
	
}
