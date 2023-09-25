package com.farhad.example.template_method;

public class App {
    
    public static void main(String[] args) {
        HalflingThief halflingThief = new HalflingThief(new HitAndRunMethod());
        halflingThief.steal();

        halflingThief.changeMethod(new SubtleMethod());
        halflingThief.steal();
    }
}
