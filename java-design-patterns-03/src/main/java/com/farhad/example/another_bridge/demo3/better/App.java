package com.farhad.example.another_bridge.demo3.better;

public class App {

	public static void main(String[] args) {
		StudentRepository studentRepository = new StudentRepository(new FileStorage());
		studentRepository.save(new Student());
	}
}
