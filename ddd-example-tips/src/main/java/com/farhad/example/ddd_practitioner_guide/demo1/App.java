package com.farhad.example.ddd_practitioner_guide.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.zalando.jackson.datatype.money.MoneyModule;

@SpringBootApplication
public class App {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	MoneyModule moneyModule() {
		return new MoneyModule().withAmountFieldName("value");
	}
}
