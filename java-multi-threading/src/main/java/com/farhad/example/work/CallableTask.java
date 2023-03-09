package com.farhad.example.work;

import java.util.concurrent.Callable;

public interface CallableTask extends Callable<Double> {

    String name() ;
    
}
