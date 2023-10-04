package com.farhad.example.monostate;

public class UnLocked  extends Turnstile{

    @Override

    public void coin() {
        refunds();
    }

    @Override
    public void pass() {
        lock(true);
        itsState = LOCKED;
    }

    

}
