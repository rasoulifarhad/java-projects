package com.farhad.example.working_legacy_code.programming_by_difference;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MessageForwarderTest {

    MimeMessage expectedMessage;

    @Test
    public void testAnonymous() throws Exception {
        MessageForwarder forwarder = new MessageForwarder();
        forwarder.forwardMessage(makeFakeMessage());
        assertEquals("anon-members@" + forwarder.getDomain(), 
                expectedMessage.getFrom().toString());
    }

    private Message makeFakeMessage() {
        return null;
    } 
}
