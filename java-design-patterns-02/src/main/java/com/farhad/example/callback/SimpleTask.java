package com.farhad.example.callback;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleTask extends Task {

    @Override
    public void execute() {
        log.info("Do some work then call callback method.");
    }
    
}
