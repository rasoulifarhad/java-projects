package com.farhad.example.designpatterns.chainofresponsibility;

import org.junit.jupiter.api.Test;

import com.farhad.example.designpatterns.chainofresponsibility.SupportHandlerDemoGof.AbstractSupportHandler;

public class SupportHandlerDemoGof_RequestorClientTest {
    @Test
    void testGetHandlerChain() {

        SupportHandlerDemoGof.AbstractSupportHandler handler = SupportHandlerDemoGof.RequestorClient.getHandlerChain();
        handler.receiveRequest(AbstractSupportHandler.TECHNICAL, " I'm having problem with my internet connectivity.");
        handler.receiveRequest(AbstractSupportHandler.BILLING, "Please resend my bill of this month.");
        handler.receiveRequest(AbstractSupportHandler.GENERAL, "Please send any other plans for home users.");

    }
}
