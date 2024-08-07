package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.hidden_dependency.better;

import java.util.EnumSet;

import com.farhad.example.work_effevtively_with_legacy_code.fake_objects.hidden_dependency.better.MailingListDispatcher.ClientType;

public class MailService implements IMailService {

    @Override
    public void connect() {
    }

    @Override
    public int getStatus() {
        return 0;
    }

    @Override
    public void register(MailingListDispatcher mailingListDispatcher, int clientType, String markMessageOff) {
    }

    @Override
    public void setParam(int clientType, EnumSet<ClientType> of) {
    }

}
