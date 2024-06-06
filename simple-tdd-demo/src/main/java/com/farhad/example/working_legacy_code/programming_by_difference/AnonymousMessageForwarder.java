package com.farhad.example.working_legacy_code.programming_by_difference;

public class AnonymousMessageForwarder extends MessageForwarder {

    private String listAddress = "members";

    @Override
    protected InternetAddress getFromAddress(Message message) throws MessagingException {
        String anonymousAddress = "anon-" + listAddress + "@" + getDomain(); 
        return new InternetAddress(anonymousAddress);
    }

    

}
