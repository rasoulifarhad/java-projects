package com.farhad.example.work_effevtively_with_legacy_code.fake_objects;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Sale {

    private Item item;
    
    private final ArtR56Display display;


    public void scan(String barcode) {
        String itemLine = item.getName() 
            + " " + item.getPrice().asDisplayText();
        display.showLine(itemLine);
    }
}
