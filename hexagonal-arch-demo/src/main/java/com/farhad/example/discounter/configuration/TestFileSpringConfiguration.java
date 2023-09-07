package com.farhad.example.discounter.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.discounter.adapters.Driver;
import com.farhad.example.discounter.adapters.discounter.testcases.TestRunner;

@Configuration
@ConditionalOnProperty(name = "config", havingValue = "test-file")
public class TestFileSpringConfiguration {
	
	@Bean
	public Driver testCases() {
		return new TestRunner("file");
	}
}
