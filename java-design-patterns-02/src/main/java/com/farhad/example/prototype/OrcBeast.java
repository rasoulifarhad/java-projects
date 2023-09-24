package com.farhad.example.prototype;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString(includeFieldNames = false)
public class OrcBeast extends Beast {

    private final String description = "Orcish wolf";

    @Override
    public Beast clone() throws CloneNotSupportedException {
        return new OrcBeast();
    }
    
}
