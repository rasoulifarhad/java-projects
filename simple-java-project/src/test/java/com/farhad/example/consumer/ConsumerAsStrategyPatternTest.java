package com.farhad.example.consumer;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import com.farhad.example.consumer.ConsumerAsStrategyPattern.EmailManager;

public class ConsumerAsStrategyPatternTest {

    @Test
    void testCreateAndDisplayEmail() {
        EmailManager emailManager = new EmailManager();
        String emailBody = "This is email from me";
        Consumer<String> farhadEmailConsumer = emailManager::createAndDisplayEmail;
        System.out.println();
        emailManager.createMailAndDisplay(farhadEmailConsumer, emailBody);
    }

    @Test
    void testCreateAndDisplayAdminEmail() {
        EmailManager emailManager = new EmailManager();
        String emailBody = "This is email from me";
        Consumer<String>  adminEmailConsumer = emailManager::createAndDisplayAdminEmail;
        System.out.println();
        emailManager.createMailAndDisplay(adminEmailConsumer, emailBody);
    }
    
}
