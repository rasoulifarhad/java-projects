package com.farhad.example.anotherddd;

import java.util.ArrayList;
import java.util.Collection;

public class DomainEvents {

    private static Collection<DomainEvent> events = new ArrayList<>();
    public static void add(DomainEvent event){
        events.add(event);
    }
    
    public static void dispatch(DomainEvent domainEvent){

    }

}
