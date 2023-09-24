package com.farhad.example.prototype;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class ElfMage extends Mage {
    
    private String description = "Eleven mage";

    @Override
    public Mage clone() throws CloneNotSupportedException {
        return new ElfMage();
    }

}
