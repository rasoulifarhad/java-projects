package com.farhad.example.dispatch.displayport;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Oval implements Displayable{

    @Override
    public void displayOn(Port port) {
        // if (port instanceof DisplayPort) {
        //     log.info("Oval displayed in display port");
        // } 

        // if (port instanceof PrinterPort) {
        //     log.info("Oval displayed in printer port");
        // } 

        // if (port instanceof RemotePort) {
        //     log.info("Oval displayed in remote port");
        // } 
        port.display(this);

    }
    
}
