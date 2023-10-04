package com.farhad.example.monostate;

/**
 * Consider implementing the simple finite state machine for a subway turnstile The turnstile 
 * begins its life in the Locked state. If a coin is deposited, it transitions to the Unlocked 
 * state, unlocks the gate, resets any alarm state that might be present, and deposits the 
 * coin in its collection bin. If a user passes through the gate at this point, the turnstile 
 * transitions back to the Locked state and locks the gate.
 * 
 * There are two abnormal conditions. If the user deposits two or more coins before passing 
 * through the gate, the coins will be refunded and the gate will remain unlocked. If the 
 * user passes through without paying, then an alarm will sound and the gate will remain 
 * locked.
 */
public class App {
    
}
