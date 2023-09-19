package com.farhad.example.design_principles02.ppp.exercise_2_srp.library;

import java.util.Date;

public class StandardTimeSource implements TimeSource{

    @Override
    public Date getTime() {
        return new Date();
    }
    
}
