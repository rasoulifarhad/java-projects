package com.farhad.example.refactoring.call_super.bad;

// You are inheriting from a super-class in order to plug into some framework. The documentation 
// says something like "to do your own thing, just subclass the process method. However it's 
// important to remember to start your method with a call to the super-class". 
//
// Whenever you have to remember to do something every time, that's a sign of a bad API. 
//
// Instead the API should remember the housekeeping call for you. The usual way to do this is 
// to make the handle method a Template Method,
public class App {

}
