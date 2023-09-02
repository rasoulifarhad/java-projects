package com.farhad.example.wiremockdemo;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WireMockLocalMockServer {
	
	public static void main(String[] args) {
		log.info("Starting local mock server on port 8000");
		new WireMockServer(
			WireMockConfiguration.options()
				.usingFilesUnderClasspath("src/main/resources/wiremock")
				.port(8000)
		).start();
	}

	// http://<mock-server-host>:<port>/file-name.file-extension
	// http://localhost:8000/customers.json
	// http://localhost:8000/customers.html
}
