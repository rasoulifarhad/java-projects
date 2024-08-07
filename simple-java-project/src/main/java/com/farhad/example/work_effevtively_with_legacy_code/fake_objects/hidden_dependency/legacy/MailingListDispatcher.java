package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.hidden_dependency.legacy;

import java.util.EnumSet;

// The fundamental problem here is that the dependency on MailService is hidden 
// in the MailingListDispatcher constructor.
//
// If there was some way to replace the MailService object with a fake, we could 
// sense through the fake and get some feedback as we change the class.
public class MailingListDispatcher {

    private static final int MAIL_OK = 1;
    private static final int MAIL_OFFLINE = 2;
    
    private static final int MS_AVAILABLE = 1;

    private static final String MARK_MESSAGE_OFF = "MARK_MESSAGE_OFF";
     

    enum ClientType {
        ML_NOBOUNCE,
        ML_REPEATOFF
    }

    private MailService service;
    private int status;
    
    public MailingListDispatcher() {
        service = new MailService();
        status = MAIL_OK;

        int clientType = 12;
        service.connect();
        if(service.getStatus() == MS_AVAILABLE) {
            service.register(this, clientType, MARK_MESSAGE_OFF);
            service.setParam(clientType, EnumSet.of(ClientType.ML_NOBOUNCE, ClientType.ML_REPEATOFF));
        } else {
            status = MAIL_OFFLINE;
        }

    }

    public void sendMessage(String message) {

    }

    public void addRecipient(MailTxmId id, MailAddress address) {

    }

    
}
