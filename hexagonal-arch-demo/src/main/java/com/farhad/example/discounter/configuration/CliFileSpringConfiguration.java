package com.farhad.example.discounter.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.discounter.adapters.Driver;
import com.farhad.example.discounter.adapters.discounter.cli.CommandLineInterface;
import com.farhad.example.discounter.adapters.rate.repository.file.FileRateRepository;
import com.farhad.example.discounter.application.DiscounterApp;
import com.farhad.example.discounter.application.ports.Discounter;
import com.farhad.example.discounter.application.ports.RateRepository;

@Configuration
@ConditionalOnProperty(name = "config", havingValue = "cli-file")
public class CliFileSpringConfiguration {

	@Value("${rate.file}")
	private String rateFile;

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
		return new FileRateRepository(rateFile);
	}
	
}
