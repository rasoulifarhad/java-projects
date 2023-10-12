package com.farhad.example.ddd_tips.flight_monitoring_system.third;

// each plane is assigned a flight plan which is supposed to describe the entire air travel.
// what planes do while flying, they follow a route.
// departure and destination points of the aircraft are also the starting and ending points of the route
//
// route is made up of small segments, which put together constitute some sort of a crooked line from departure to destination.
// The line is supposed to pass through predetermined fixed points. So, a route can be considered as a series of consecutive fixes.
// At this point you no longer see the departure and destination as the terminal points of the route, but just another two of those fixes.
public class Aircraft {
	
	private Route route;
}
