package com.farhad.example.ddd_tips.flight_monitoring_system.fifth;

// each plane is assigned a flight plan which is supposed to describe the entire air travel.
// what planes do while flying, they follow a route.
// departure and destination points of the aircraft are also the starting and ending points of the route
//
// route is made up of small segments, which put together constitute some sort of a crooked line from departure to destination.
// The line is supposed to pass through predetermined fixed points. So, a route can be considered as a series of consecutive fixes.
// At this point you no longer see the departure and destination as the terminal points of the route, but just another two of those fixes.
// The fixes are just points on Earth surface uniquely determined by their latitude and longitude.
// 
// planes/departure//destination/route/latitude/latitude/fix/flight plan/cruise altitude/cruise speed/airplane,

// The pilots receive a route they must follow
// The route goes through a series of points on the ground determined by their latitude and longitude.
// The altitude that an airplane is to have at a certain moment is also established in the flight plan.
// Before leaving the airport, the pilots receive a detailed flight plan which includes all sorts of information about theflight:
// the route, cruise altitude, the cruise speed, the type of airplane, even information about the crew members.
public class Aircraft {
	
	private FlightPlan flightPlan;
}
