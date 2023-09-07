package com.farhad.example.discounter.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.discounter.adapters.Driver;
import com.farhad.example.discounter.adapters.discounter.cli.CommandLineInterface;
import com.farhad.example.discounter.application.DiscounterApp;
import com.farhad.example.discounter.application.ports.Discounter;

@Configuration
@ConditionalOnProperty(name = "config", havingValue = "cli-none")
public class CliNoneSpringConfiguration {
	
	@Bean
	public Driver cli(Discounter discounterApp) {
		return new CommandLineInterface(discounterApp);
	}

	@Bean
	public Discounter discounterApp() {
		return new DiscounterApp(null);
	}
}
