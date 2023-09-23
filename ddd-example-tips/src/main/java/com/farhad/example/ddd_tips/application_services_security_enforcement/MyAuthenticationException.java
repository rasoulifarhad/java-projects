package com.farhad.example.ddd_tips.application_services_security_enforcement;

import org.springframework.security.core.AuthenticationException;

public class MyAuthenticationException extends AuthenticationException {

    public MyAuthenticationException(String msg) {
        super(msg);
    }

}
