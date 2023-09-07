package com.farhad.example.discounter.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "config", havingValue = "cli-stub")
public class CliStubSpringConfiguration {
	
}
