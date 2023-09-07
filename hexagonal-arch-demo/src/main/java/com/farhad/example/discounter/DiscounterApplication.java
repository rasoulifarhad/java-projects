package com.farhad.example.discounter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.farhad.example.discounter.adapters.Driver;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootApplication
public class DiscounterApplication implements CommandLineRunner {

	private final Driver driver;

	public static void main(String[] args) {
		SpringApplication.run(DiscounterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Running DiscounterApplication....");
		this.driver.run(args);
	}
}
