package com.farhad.example.design_principles02.rock_paper_scissors_game.better;

// name: Double dispatch
//
// problem: Select an action based on type of two objects appearing in combi naTION
//
// Context: Sometimes you need to write code that makes decisions about what to do based on the class oF one of the 
// parameters to a method.
//
// Forces: Case or switch statements are often used in procedural languages to decide what action to take. But deciding 
// what to do based on the class of a parameter can result in code that is hard to maintain; each time you add a new 
// class, working code will have to be modified.
//
// Solution: Instead of writing code that specifically checks the class of a parameter, add new methods having the same name 
// (a secondary method) to each class of all the potential parameter objects. Write the original method to simply call this 
// new secondary method, passing the original receiver as an argument. It is the responsibility of each object receiving this 
// secondary message to know specifically what should be done. Typically, each secondary method turns around and invokes a 
// specific operation on the original receiver (hence the name Double Dispatch).
// 
// You can tie the specific operation to the class of object by appending the class name of each class that implements a secondary 
// method to the name of this specialized operation.If necessary,pass the original receiver as an argument to these specialized 
// operations as well.
//
// 
public class GameCordinator {

	public static void main(String[] args) {
		
	}
}
