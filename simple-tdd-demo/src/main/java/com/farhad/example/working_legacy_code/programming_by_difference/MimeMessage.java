package com.farhad.example.working_legacy_code.programming_by_difference;

import lombok.Getter;

@Getter
public class MimeMessage {

    private InternetAddress from;
    private Session session;

    public MimeMessage(Session session) {
        this.session = session;
    }

    public void setFrom(InternetAddress fromAddress) {
        this.from = fromAddress;
    }

}
