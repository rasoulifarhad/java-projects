package com.farhad.example.discounter.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.discounter.adapters.Driver;
import com.farhad.example.discounter.adapters.discounter.cli.CommandLineInterface;
import com.farhad.example.discounter.adapters.rate.repository.testdouble.StubRateRepository;
import com.farhad.example.discounter.application.DiscounterApp;
import com.farhad.example.discounter.application.ports.Discounter;
import com.farhad.example.discounter.application.ports.RateRepository;

@Configuration
@ConditionalOnProperty(name = "config", havingValue = "cli-stub")
public class CliStubSpringConfiguration {
	
	@Bean
	public Driver cli(Discounter discounterApp) {
		return new CommandLineInterface(discounterApp);
	}

	@Bean
	public Discounter discounterApp(RateRepository rateRepository) {
		return new DiscounterApp(rateRepository);
	}

	@Bean
	public RateRepository fileRateRepository() {
		return new StubRateRepository();
	}


}
