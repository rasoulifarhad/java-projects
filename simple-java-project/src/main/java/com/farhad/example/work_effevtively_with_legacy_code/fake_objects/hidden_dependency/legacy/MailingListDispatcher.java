package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.hidden_dependency.legacy;

import java.util.EnumSet;

public class MailingListDispatcher {

    private static final int MAIL_OK = 1;
    private static final int MAIL_OFFLINE = 2;
    
    private static final int MS_AVAILABLE = 1;

    private static final String MARK_MESSAGE_OFF = "MARK_MESSAGE_OFF";
     

    enum ClientType {
        ML_NOBOUNCE,
        ML_REPEATOFF
    }

    private MaiService service;
    private int status;
    
    public MailingListDispatcher() {
        service = new MaiService();
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
