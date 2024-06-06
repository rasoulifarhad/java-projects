package com.farhad.example.working_legacy_code.programming_by_difference;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MessageForwarderTest {

    Message expectedMessage;

    @Test
    public void testForwarder() throws Exception {
        MessageForwarder forwarder = new MessageForwarder();
        MimeMessage mimeMessage = forwarder.forwardMessage(makeFakeMessage(forwarder.getDomain()));
        expectedMessage = new Message();
        expectedMessage.from(mimeMessage.getFrom().getAddress());
        System.out.println(expectedMessage);
        assertEquals("fakeFrom@" + forwarder.getDomain(), 
                expectedMessage.getFrom()[0].toString());
    }

    @Test
    public void testAnonymous() throws Exception {
        MessageForwarder forwarder = new AnonymousMessageForwarder();
        MimeMessage mimeMessage = forwarder.forwardMessage(makeFakeMessage(forwarder.getDomain()));
        expectedMessage = new Message();
        expectedMessage.from(mimeMessage.getFrom().getAddress());
        assertEquals("anon-members@" + forwarder.getDomain(), 
                expectedMessage.getFrom()[0].toString());
    }

    private Message makeFakeMessage(String domain) {
        Message m = new Message();
        m.from("fakeFrom@" + domain);
        return m;
    } 
}
