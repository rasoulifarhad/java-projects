package com.farhad.example.design_principles02.time_billing;

//
// - Identify the objects and their attributes
// - Determine what can be done to each object
// - Determine what each object is allowed to do to other objects
//   
//     The two generic things objects can do to each other are containment and inheritance. 
//     Which objects can contain which other objects? 
//     Which objects can inherit from which other objects?
//
//     - A timecard object can contain an employee object and a client object,
//     - A bill can contain one or more timecards.In addition,a bill can indicate that a client has been billed,and 
//     - A client can enter payments against a bill.
// - Determine the parts of each object that will be visible to other objects
// - Define each object’s interfaces
public class App {

	public static void main(String[] args) {
		
	}
}
