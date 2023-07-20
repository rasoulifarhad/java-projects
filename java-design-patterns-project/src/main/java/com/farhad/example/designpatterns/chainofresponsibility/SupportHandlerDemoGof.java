package com.farhad.example.designpatterns.chainofresponsibility;

public class SupportHandlerDemoGof {
    

    public static abstract class AbstractSupportHandler {
        public static final int TECHNICAL = 1;
        public static final int BILLING = 2;
        public static final int GENERAL = 3;

        protected int level;
        protected AbstractSupportHandler nextHandler;

        public void setNextHandler(AbstractSupportHandler nextHandler) {
            this.nextHandler = nextHandler;
        }

        public void receiveRequest(int level, String message) {
            if (this.level <= level) {
                handleRequest(message);
            }
            if (nextHandler != null ) {
                nextHandler.receiveRequest(level, message);
            }
        }

        protected abstract void handleRequest(String message) ;

    }

    public static class TechnicalSupportHandler extends AbstractSupportHandler {

        public TechnicalSupportHandler(int level) {
            this.level = level;
        }
        @Override
        protected void handleRequest(String message) {
            System.out.println("TechnicalSupportHandler: Processing request " + message);
        }

    }

    public static class BillingSupportHandler extends AbstractSupportHandler {

        public BillingSupportHandler(int level) {
            this.level = level;
        }
        @Override
        protected void handleRequest(String message) {
            System.out.println("BillingSupportHandler: Processing request " + message);

        }

    }    

    public static class GeneralSupportHandler extends AbstractSupportHandler {

        public GeneralSupportHandler(int level) {
            this.level = level;
        }
        @Override
        protected void handleRequest(String message) {
            System.out.println("GeneralSupportHandler: Processing request " + message);

        }

    }     
    
    public static class RequestorClient {
        public static AbstractSupportHandler getHandlerChain() {
            AbstractSupportHandler technical = new TechnicalSupportHandler(AbstractSupportHandler.TECHNICAL);
            AbstractSupportHandler billing = new BillingSupportHandler(AbstractSupportHandler.BILLING);
            AbstractSupportHandler general = new GeneralSupportHandler(AbstractSupportHandler.GENERAL);

            technical.setNextHandler(billing);
            billing.setNextHandler(general);

            return technical;
        }
    }
}
