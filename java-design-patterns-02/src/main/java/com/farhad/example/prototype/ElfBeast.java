package com.farhad.example.prototype;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString(includeFieldNames = false)
public class ElfBeast extends Beast {

    private final String description = "Elven eagle ";

    @Override
    public Beast clone() throws CloneNotSupportedException {
        return new ElfBeast();
    }
    
}
