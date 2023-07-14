package com.farhad.example.designpatterns.anotherDecorator;

import lombok.RequiredArgsConstructor;

// a notification library which lets other programs notify their users about important events.
//
// The initial version of the library was based on the Notifier class that had only a few fields, a constructor and a single send 
// method. 
// The method could accept a message argument from a client and send the message to a list of emails that were passed to the notifier 
// via its constructor. A third-party app which acted as a client was supposed to create and configure the notifier object once, and 
// then use it each time something important happened.
//
// Aggregation: Object A contains objets B; B can lives without A.
// Composition: Objetc A consists of objects B; A manages life cycle of B ; B can not live without A.
// 
// “Wrapper” is the alternative nickname for the Decorator pattern that clearly expresses the main idea of the pattern.
// A wrapper is an object that can be linked with some target object. The wrapper contains the same set of methods as the target 
// and delegates to it all requests it receives. However, the wrapper may alter the result by doing something either before or 
// after it passes the request to the target. 
public class NotificationDecoratorGof {
    
    @RequiredArgsConstructor
    static class App {
        private final Notifier notifier;


        public void doSomething() {
            notifier.send("Alert");
        }

        public static void main(String[] args) {
            Notifier stack = new EmailNotifier();
            stack = new FacebookDecorator(stack);
            stack = new SmsDecorator(stack);
            
            App app = new App(stack);
            app.doSomething();
        }
    }
    
    interface Notifier {
        public void send(String message);
    }

    static class EmailNotifier implements Notifier {

        @Override
        public void send(String message) {
            System.out.println("Email sended for: " + message);
        }
    }

    static class SMSNotifier implements Notifier {

        @Override
        public void send(String message) {
            System.out.println("Sms sended for: " + message);
        }
    }

    static class FacebookNotifier implements Notifier {

        @Override
        public void send(String message) {
            System.out.println("Facebook notification sended for: " + message);
        }
    }

    static class SmsEmailFacebookNotifier implements Notifier {

        @Override
        public void send(String message) {
            System.out.println("Email sended for: " + message);
            System.out.println("Sms sended for: " + message);
            System.out.println("Facebook notification sended for: " + message);
        }
    }

    static class SmsEmailNotifier implements Notifier {

        @Override
        public void send(String message) {
            System.out.println("Email sended for: " + message);
            System.out.println("Sms sended for: " + message);
        }
    }

    static class BaseDecorator implements Notifier {
        private final Notifier notifier;

        public BaseDecorator(Notifier notifier) {
            this.notifier = notifier;
        }
        @Override
        public void send(String message) {
            notifier.send(message);
        }   
    }

    static class EmailDecorator extends BaseDecorator {

        public EmailDecorator(Notifier notifier) {
            super(notifier);
        }

        @Override
        public void send(String message) {
            super.send(message);
            sendEmail(message);
        }

        private void sendEmail(String message) {
            System.out.println("Email sended for: " + message);
        }
    }

    static class SmsDecorator extends BaseDecorator {

        public SmsDecorator(Notifier notifier) {
            super(notifier);
        }

        @Override
        public void send(String message) {
            super.send(message);
            sendSms(message);
        }

        private void sendSms(String message) {
            System.out.println("Sms sended for: " + message);
        }
    }

    static class FacebookDecorator extends BaseDecorator {

        public FacebookDecorator(Notifier notifier) {
            super(notifier);
        }

        @Override
        public void send(String message) {
            super.send(message);
            sendFacebookNotif(message); 
        }

        private void sendFacebookNotif(String message) {
            System.out.println("Facebook notification sended for: " + message);
        }
        
    }
}
