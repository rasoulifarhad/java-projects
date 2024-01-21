package com.farhad.example.login_observer_pattern.room;

public class RoomFamily extends Room_Template {

	public RoomFamily(Room templ_room) {
		super(templ_room);
	}

	public double getCost() {
		return templ_room.getCost() + 20.00;
	}

	@Override
	public String getRoomType() {
		return "Family";
	}

}
