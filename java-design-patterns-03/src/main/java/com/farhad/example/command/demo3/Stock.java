package com.farhad.example.command.demo3;

import lombok.AllArgsConstructor;
import lombok.Data;

// receiver
@AllArgsConstructor
@Data
public class Stock {

    private String name="ABC";
    private int quantity= 10;

    public void buy(){
        System.out.println("Stock [ Name: "+name+",Quantity: " + quantity +" ] bought");
    }

    public void sell() {
        System.out.println("Stock [ Name: "+name+",Quantity: " + quantity +" ] sold");

    }
}
