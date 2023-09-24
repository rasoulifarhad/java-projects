package com.farhad.example.prototype;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class ElfWarlord extends Warlord {

    private final String description = "Elven warlord";

    @Override
    public Warlord clone() throws CloneNotSupportedException {
        return new ElfWarlord();
    }
    
}
