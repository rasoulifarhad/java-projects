package com.farhad.example.prototype;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class OrcMage extends Mage {

    private String description = "Orcish mage";

    @Override
    public Mage clone() throws CloneNotSupportedException {
        return new OrcMage();
    }
}
