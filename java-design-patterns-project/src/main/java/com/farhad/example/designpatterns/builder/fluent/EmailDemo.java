package com.farhad.example.designpatterns.builder.fluent;

import com.farhad.example.designpatterns.builder.fluent.EmailDemo.Email.EmailBuilder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

//See https://github.com/MilindAtGithub/fluentbuilder/tree/master
public class EmailDemo {
    
    @Data
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    static class Email {

        private String to;
        private String from;
        private String subject;
        private String content;
        private String bcc;
        private String cc;

        private Email(EmailBuilder builder) {
            this.from = builder.from;
            this.to = builder.to;
            this.subject = builder.subject;
            this.content = builder.content;
            this.bcc = builder.bcc;
            this.cc = builder.cc;
        }
        interface EmailFrom {
            EmailTo from(String from);
        }        

        interface EmailTo {
            EmailSubject to(String to);
        }

        interface EmailSubject {
            EmailContent subject(String subject);
        }

        interface EmailContent {
            EmailCreator content(String content);
        }

        interface EmailCreator {
            EmailCreator bcc(String bcc);
            EmailCreator cc(String bcc);
            Email build();
        }


        static class EmailBuilder implements EmailFrom, EmailTo, EmailSubject, EmailContent, EmailCreator {

            private String to;
            private String from;
            private String subject;
            private String content;
            private String bcc;
            private String cc;

            public static EmailFrom instance() {
                return new EmailBuilder();
            }

            private EmailBuilder() {

            }

            @Override
            public EmailCreator bcc(String bcc) {
                this.bcc = bcc;
                return this;
            }

            @Override
            public EmailCreator cc(String cc) {
                this.cc = cc;
                return this;
            }

            @Override
            public EmailCreator content(String content) {
                this.content = content;
                return this;
            }

            @Override
            public EmailContent subject(String subject) {
                this.subject = subject;
                return this;
            }

            @Override
            public EmailSubject to(String to) {
                this.to = to;
                return this;
            }

            @Override
            public EmailTo from(String from) {
                this.from = from;
                return this;
            }

            @Override
            public Email build() {
                return new Email(this);
            }
        }
    }

    public static void main(String[] args) {
        Email email = EmailBuilder.instance()
                        .from("test@example.com")
                        .to("boyOrGirl@example.com")
                        .subject("Email builder test")
                        .content("this content constructed with fluent builder pattern.")
                        .build();
        System.out.println(email);
    }
}
