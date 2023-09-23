package com.farhad.example.ddd_tips.application_services_security_enforcement.input_validation;

import java.util.Objects;

public class FormatValidationVODemo {
    
    public static class PhoneNumber {

    private final String phoneNumber;

    public PhoneNumber(String phoneNumber) {
        Objects.requireNonNull(phoneNumber, "phoneNumber must not be null"); // <1>
        StringBuilder sb = new StringBuilder();
        char ch;
        for (int i = 0; i < phoneNumber.length(); ++i) {
            ch = phoneNumber.charAt(i);
            if (Character.isDigit(ch)) { // <2>
                sb.append(ch);
            } else if (!Character.isWhitespace(ch) && ch != '(' && ch != ')' && ch != '-' && ch != '.') { // <3>
                throw new IllegalArgumentException(phoneNumber + " is not valid");
            }
        }
        if (sb.length() == 0) { // <4>
            throw new IllegalArgumentException("phoneNumber must not be empty");
        }
        this.phoneNumber = sb.toString();
    }

    @Override
    public String toString() {
        return phoneNumber;
    }        
    }
}
