package com.farhad.example.monostate;

public class Locked extends Turnstile{

    @Override
    public void coin() {
        itsState = UNLOCKED;
        lock(false);
        alarm(false);
        deposit();
    }

    @Override
    public void pass() {
        alarm(true);
    }

}
