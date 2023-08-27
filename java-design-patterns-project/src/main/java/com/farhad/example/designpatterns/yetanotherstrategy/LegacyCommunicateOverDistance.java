package com.farhad.example.designpatterns.yetanotherstrategy;

import lombok.Data;

// https://riptutorial.com/design-patterns/example/12362/using-java-8-functional-interfaces-to-implement-the-strategy-pattern
public class LegacyCommunicateOverDistance {
    
    interface CommunicateInterface {
        String comunicate(String destination);
    }

    static class CommunicateViaPhone implements CommunicateInterface {

        @Override
        public String comunicate(String destination) {
            return "Communicating " + destination + " via phome";
        }

    }

    static class CommunicatingViaEmail implements CommunicateInterface {

        @Override
        public String comunicate(String destination) {
            return "Communicating " + destination + " via email";
        }

    }

    static class CommunicatingViaVideo implements CommunicateInterface {

        @Override
        public String comunicate(String destination) {
            return "Communicating " + destination + " via video";
        }

    }

    @Data
    static class CommunicationService  {
        private CommunicateInterface communicateMeans;

        public void communicate(String destination) {
            System.out.println(communicateMeans.comunicate(destination));
        }
    }

    public static void main(String[] args) {
        CommunicationService communicationService = new CommunicationService();

        CommunicateViaPhone communicateViaPhone = new CommunicateViaPhone();
        communicationService.setCommunicateMeans(communicateViaPhone);
        communicationService.communicate("1234567");

        CommunicatingViaEmail communicatingViaEmail = new CommunicatingViaEmail();
        communicationService.setCommunicateMeans(communicatingViaEmail);
        communicationService.communicate("example@example.com");
    }

}
