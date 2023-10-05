package com.farhad.example.ddd_tips.application_service;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles({ "domain-test", "mock-order-repository", "mock-client-service" })
@SpringBootTest
public class ApplicationTest {
}
