package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.dip.bad;

// The DIP can be stated as the following:
//
// A. High-level classes should not dependent on low-level classes.Both of them should depend on abstractions.
//
// B. Abstractions should not depend upon details.Details should depend upon abstractions
//
// Suppose you are building an authentication and membership system for a web application that needs to manage 
// users.As a part of user management,a way to a change password is required.When a password is changed,a 
// notification is to be sent to the user about the change.
//
// In this case the class doing the user management is the high-level class,and the class sending notification 
// is a low-level class.
public class App {

}
