package com.farhad.example.working_legacy_code.programming_by_difference;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Message {

    private Address from;
    private List<Address> ccs = new ArrayList<>();
    
    public Message() {
    }

    public void from(String from) {
        this.from = new Address(from);
    }
    public Address[] getFrom() {
        return new Address[] { from };
    }

    public void addCc(String cc) {
        ccs.add(new Address(cc));
    }

}
