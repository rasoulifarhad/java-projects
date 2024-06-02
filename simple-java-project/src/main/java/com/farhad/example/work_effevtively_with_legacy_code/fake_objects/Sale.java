package com.farhad.example.work_effevtively_with_legacy_code.fake_objects;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Sale {

    private Item item;
    
    private final Display display;


    public void scan(String barcode) {
        item = findItem(barcode);
        String itemLine = item.getName() 
            + " " + item.getPrice().asDisplayText();
        display.showLine(itemLine);
    }


    private Item findItem(String barcode) {
        return new Item("Milk", new Price(3.99));
    }


}
