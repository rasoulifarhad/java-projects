package com.farhad.example.monostate;

public class Turnstile {

    static boolean isLocked = true;
    static boolean isAlarming = false;
    static int itsCoins = 0;
    static int itsRefunds = 0;
    static Turnstile LOCKED  = new Locked();
    static Turnstile UNLOCKED  = new UnLocked();
    static Turnstile itsState = LOCKED;

    public void reset() {
        isLocked = true;
        isAlarming = false;
        itsCoins = 0;
        itsRefunds = 0;
        itsState = LOCKED;
    }

    public boolean locked() {
        return isLocked;
    }

    public boolean alarm() {
        return isAlarming;
    }

    public void coin() {
        itsState.coin();
    }

    public int coins() {
        return itsCoins;
    }

    public void pass() {
        itsState.pass();
    }

    public int refunds() {
        return itsRefunds++;
    }

    public void deposit() {
        itsCoins++;
    }

    protected void alarm(boolean shouldAlarm) {
        isAlarming = shouldAlarm;
    }

    protected void lock(boolean shouldLock) {
        isLocked = shouldLock;
    }
    
}
