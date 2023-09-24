package com.farhad.example.prototype;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class OrcWarlord extends Warlord {

    private final String description = "Orcish warlord";
    @Override
    public Warlord clone() throws CloneNotSupportedException {
        return new OrcWarlord();
    }
    
}
