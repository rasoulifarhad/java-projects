package com.farhad.example.strategy.demo1;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApplicationRunner {
    
    private Application itsApplication = null;;


    public void run() {
        itsApplication.init();;
        while (!itsApplication.done()) {
            itsApplication.idle();
        }
        itsApplication.cleanup();
    }
}
