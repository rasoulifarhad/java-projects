package com.farhad.example.dispatch.displayport;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Rectangle implements Displayable{


    public void displayOn(Port port) {
        // if (port instanceof DisplayPort) {
        //     log.info("Recangle displayed in display port");
        // } 

        // if (port instanceof PrinterPort) {
        //     log.info("Recangle displayed in printer port");
        // } 

        // if (port instanceof RemotePort) {
        //     log.info("Recangle displayed in remote port");
        // } 
        port.display(this);

    }
    
}
