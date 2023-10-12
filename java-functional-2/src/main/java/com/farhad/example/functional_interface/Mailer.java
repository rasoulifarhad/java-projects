package com.farhad.example.functional_interface;

public class Mailer {
    
    public void from(final String address){

    }

    public void to(final String address) {

    }

    public void subject(final String line) {

    }

    public void body(final String content) {

    }

    public void send() {
        System.out.println("Sending...");
    }

    public static void main(String[] args) {
        Mailer mailer = new Mailer();
        mailer.from("from@example.com");
        mailer.to("to@example.com");
        mailer.subject("from to mailer");
        mailer.body("... from to mailer ...");
        mailer.send();
    }
}
