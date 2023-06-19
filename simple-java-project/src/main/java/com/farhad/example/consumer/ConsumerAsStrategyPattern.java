package com.farhad.example.consumer;

import java.io.StringWriter;
import java.util.function.Consumer;

public class ConsumerAsStrategyPattern {
    
    static class EmailManager {

        public void createAndDisplayEmail(String emailBody) {
            StringWriter writer = new StringWriter();
            writer.append("Hi,");
            writer.append("\n");
            writer.append(emailBody);
            writer.append("\n");
            writer.append("Thanks, Farhad");
            System.out.println(writer.toString());
        }


        public void createAndDisplayAdminEmail(String emailBody) {
            StringWriter writer = new StringWriter();
            writer.append("Hi,");
            writer.append("\n");
            writer.append(emailBody);
            writer.append("\n");
            writer.append("Thanks, Admin");
            System.out.println(writer.toString());
        }

        public void createMailAndDisplay(Consumer<String> consumer, String emailBody) {
            consumer.accept(emailBody);
        }
    }

    public static void main(String[] args) {
        EmailManager emailManager = new EmailManager();

        String emailBody = "This is email from me";
        Consumer<String> farhadEmailConsumer = emailManager::createAndDisplayEmail;
        Consumer<String>  adminEmailConsumer = emailManager::createAndDisplayAdminEmail;

        System.out.println();
        emailManager.createMailAndDisplay(farhadEmailConsumer, emailBody);
        System.out.println();
        emailManager.createMailAndDisplay(adminEmailConsumer, emailBody);
    }
}
