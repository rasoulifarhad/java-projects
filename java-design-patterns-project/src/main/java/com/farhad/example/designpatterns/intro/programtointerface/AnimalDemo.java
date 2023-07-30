package com.farhad.example.designpatterns.intro.programtointerface;

public class AnimalDemo {
	
	interface Animal {
		void makeSound();

		public static Animal getAnimal() {
			return new Dog();
		}
	}
	static class Dog implements Animal {

		@Override
		public void makeSound() {
			bark();
		}

		public void bark() {
			System.out.println("Barking....");
		}

		
	}

	static class Cat implements Animal {

		@Override
		public void makeSound() {
			meow();
		}

		public void meow() {
			System.out.println( "Meowing....");
		}
		
	}

	public static void main(String[] args) {
		
		Dog d = new Dog();
		d.bark();

		Animal dog = new Dog();
		dog.makeSound();

		Animal cat = new Cat();
		cat.makeSound();

		Animal animal = Animal.getAnimal();
		animal.makeSound();
	}
}
