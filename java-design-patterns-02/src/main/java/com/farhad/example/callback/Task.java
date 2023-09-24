package com.farhad.example.callback;

import java.util.Objects;

public abstract class Task {
    

    public final void executeWith(Callback calback){
        Objects.requireNonNull(calback);
        execute();
        calback.call();
    }


    abstract void execute(); 
}
