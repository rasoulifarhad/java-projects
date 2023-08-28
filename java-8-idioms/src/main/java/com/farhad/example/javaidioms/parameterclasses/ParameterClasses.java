package com.farhad.example.javaidioms.parameterclasses;

// See https://wiki.c2.com/?ParameterClasses
//
// How can you parameterise the behaviour of a Java program based on external data? 
// You often need to modify the behaviour of a program based on external data, such as a command-line parameter.
//
// Take advantage of Java's built-in facilities for dynamic loading and linking of code. 
//
//  1. Define an interface through which to access the parameterised behaviour
//
//  2. Define a naming scheme that maps user-specified parameters to the name of a 
//     Java class.
//
//  3. Define classes that implement the interface for various parameters, and follow 
//     the naming scheme so that they can be found by the parameter-to-name mapping.
//
//  4. At run time, given a parameter value, map it to the name of the Java class that 
//     performs the required behaviour.
//
//  5. Dynamically load that class using the Class.forName method.
// 
//  6. Instantiate an object of the class using the Class.newInstance method or via a 
//     Constructor of the class.
//
//  7. Cast the object to the interface you have defined and pass it to the objects 
//     that need to use the parameterised behaviour. 
public class ParameterClasses {
	
}
