package com.farhad.example.functional_interface;

public class MailBuilder {
    
    public MailBuilder from(final String address){
        return this;
    }

    public MailBuilder to(final String address) {
        return this;
    }

    public MailBuilder subject(final String line) {
        return this;
    }

    public MailBuilder body(final String content) {
        return this;
    }

    public void send() {
        System.out.println("Sending...");
    }


    public static void main(String[] args) {
        new MailBuilder()
            .from("from@example.com")
            .to("from@example.com")
            .subject("from to mailbuilder")
            .body("...from to mailbuilder...")
            .send();
    }
}
