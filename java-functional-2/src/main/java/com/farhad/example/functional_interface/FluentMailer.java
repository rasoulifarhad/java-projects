package com.farhad.example.functional_interface;

import java.util.function.Consumer;

public class FluentMailer {
    
    private FluentMailer(){}

    public FluentMailer from(final String address){
        return this;
    }

    public FluentMailer to(final String address) {
        return this;
    }

    public FluentMailer subject(final String line) {
        return this;
    }

    public FluentMailer body(final String content) {
        return this;
    }

    public static void send(final Consumer<FluentMailer> block) {
        FluentMailer fluentMailer = new FluentMailer();
        block.accept(fluentMailer);
        System.out.println("Sending...");
    }

    public static void main(String[] args) {
        FluentMailer
            .send(mailer ->
                    mailer.from("from@example.com")
                            .to("to@example.com")
                            .subject("from to fluent mailer")
                            .body("...from to fluent mailer.."));
    }

}
