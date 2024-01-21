package com.farhad.example.login_observer_pattern.room;

public class Room_Single extends Room_Template {

	public Room_Single(Room templ_room) {
		super(templ_room);
	}

	@Override
	public double getCost() {
		return templ_room.getCost() + 10.00;
	}

	@Override
	public String getRoomType() {
		return "Single";
	}

	

}
