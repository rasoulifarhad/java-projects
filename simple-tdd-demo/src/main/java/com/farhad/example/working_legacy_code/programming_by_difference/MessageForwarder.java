package com.farhad.example.working_legacy_code.programming_by_difference;

// What if we need
// to support mailing lists that are anonymous? Members of these lists can post,
// but the “from” address of their messages should be set to a particular e-mail
// address based upon the value of domain (an instance variable of the Message-
// Fowarder class).
public class MessageForwarder {

    private Session session;
    private String domain;

    
    public MimeMessage forwardMessage(Message message) throws MessagingException {
        MimeMessage forward = new MimeMessage(session);
        forward.setFrom(getFromAddress(message));
        return forward;
    }   

    // The purpose of this method is to strip out the “from” address of a received
    // mail message and return it so that it can be used as the “from” address of the
    // message that is forwarded to list recipients.
    private InternetAddress getFromAddress(Message message) throws MessagingException {
        Address [] from = message.getFrom();
        if(from != null && from.length > 0) {
            return new InternetAddress(from[0].toString());
        }

        return new InternetAddress(getDefaultFrom());
    }

    private String getDefaultFrom() {
        return "default@example.com";
    }

    public String getDomain() {
        return domain;
    }


}
