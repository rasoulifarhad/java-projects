package com.farhad.example.javaidioms.abstractfactory;

// See https://wiki.c2.com/?AbstractFactory
// See https://wiki.c2.com/?AbstractFactoryPattern
// 
// Typically, if you want to construct instances of a class, where the class is selected at run time, you...
// 
// 1. Create one AbstractFactory class for each existing class (or group of related classes) you wish to create.
//
// 2. Have a polymorphic "create instance" method on each AbstractFactory class, conforming to a common method 
//    signature, used to create instances of the corresponding class.
//
// 3. Store and pass around instances of the AbstractFactory class to control selection of the class to create. 
public class AbstractFactoryDemo {
	
	static abstract class AA {
		static AA getInstance() {
			return new A();
		}

		public void methode() {

		}
	}

	static class A extends AA {

	}
	
	static class Client {
		public static void main(String[] args) {
			AA aa = AA.getInstance();
			aa.methode();
		}
	}


}
