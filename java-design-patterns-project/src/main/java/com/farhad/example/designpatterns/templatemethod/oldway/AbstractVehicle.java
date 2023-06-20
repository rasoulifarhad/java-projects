package com.farhad.example.designpatterns.templatemethod.oldway;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractVehicle implements Vehicle {

    public void start() {
        preStartCheck();
        log.info("{} starting....", this.getClass().getSimpleName());
    }

    public abstract void preStartCheck();
}
