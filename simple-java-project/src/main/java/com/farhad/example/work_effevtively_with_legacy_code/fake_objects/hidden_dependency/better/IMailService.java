package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.hidden_dependency.better;

import java.util.EnumSet;

import com.farhad.example.work_effevtively_with_legacy_code.fake_objects.hidden_dependency.better.MailingListDispatcher.ClientType;

public interface IMailService {

    void connect();

    int getStatus();

    void register(MailingListDispatcher mailingListDispatcher, int clientType, String markMessageOff);

    void setParam(int clientType, EnumSet<ClientType> of);

}