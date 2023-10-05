package com.farhad.example.ddd_tips.application_service.application.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.farhad.example.ddd_tips.application_service.domain.model.client.ClientProvider;
import com.farhad.example.ddd_tips.application_service.domain.model.client.ClientProviderStub;

@Profile("mock-client-service")
@Configuration
public class ClientMockConfiguration {
    
    @Bean
    public ClientProvider clientProvider() {
        return new ClientProviderStub();
    }
}
