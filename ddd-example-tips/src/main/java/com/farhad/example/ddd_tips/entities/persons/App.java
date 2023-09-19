package com.farhad.example.ddd_tips.entities.persons;

import com.farhad.example.ddd_tips.entities.persons.Person.PersonId;

public class App {
	public static void main(String[] args) {
		PersonName name = new PersonName("name1");
		PersonId id = new PersonId(1l);

		Person person = new Person(id, name);
		person.changeName(new PersonName("name2"), "name2");
		person.changeName(new PersonName("name3"), "name3");
		person.changeName(new PersonName("name4"), "name4");

		person.getNameHistory().forEach(System.out::println);
	}
}
