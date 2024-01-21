package com.farhad.example.login_observer_pattern.room;

public class Room_KingSize extends Room_Template {

	public Room_KingSize(Room templ_room) {
		super(templ_room);
	}

	public double getCost() {
		return templ_room.getCost() + 40.00;
	}

	@Override
	public String getRoomType() {
		return "King";
	}
}
