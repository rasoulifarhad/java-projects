package com.farhad.example.anotherddd;

import lombok.Getter;

public class FeePaidOff implements DomainEvent {

    @Getter
    private Fee fee;

    public FeePaidOff(Fee fee) {
        this.fee = fee;
    }
}
