package com.farhad.example.designpatterns.yetanotherstrategy;

import java.util.function.Function;
import lombok.Data;

// https://riptutorial.com/design-patterns/example/12362/using-java-8-functional-interfaces-to-implement-the-strategy-pattern
public class RevisitedCommunicateOverDistance {
    
    private RevisitedCommunicateOverDistance() {
    }

    @Data
    static class CommunicationService {
        private Function<String, String> communicationMeans ;

        public void communicate(String destination) {
            System.out.println(communicationMeans.apply(destination));
        }
    }

    public static void main(String[] args) {
        Function<String, String> communicateViaPhone = destination -> "Communicate " + destination + " via phone";
        Function<String, String> communicateViaEmail = destination -> "Communicate " + destination + " via email";
        Function<String, String> communicateViaVideo = destination -> "Communicate " + destination + " via video";
     
        CommunicationService communicationService = new CommunicationService();
        communicationService.setCommunicationMeans(communicateViaPhone);
        communicationService.communicate("1234567");

        communicationService.setCommunicationMeans(communicateViaEmail);
        communicationService.communicate("example@example.com");
    }
}
