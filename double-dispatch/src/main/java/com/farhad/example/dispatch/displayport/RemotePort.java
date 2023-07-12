package com.farhad.example.dispatch.displayport;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RemotePort implements Port {

    @Override
    public void display(Rectangle rectangle) {
        log.info("display rectangle in remote port");
    }

    @Override
    public void display(Oval oval) {
        log.info("display oval in remote port");
    }


    // @Override
    // public void displayOn(Port port) {
    // }

}
