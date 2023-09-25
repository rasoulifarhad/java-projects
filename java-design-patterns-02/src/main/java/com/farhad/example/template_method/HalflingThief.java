package com.farhad.example.template_method;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class HalflingThief {
    
    @NonNull
    private StealingMethod stealingMethod;

    public void steal() {
        stealingMethod.steal();
    }

    public void changeMethod(StealingMethod stealingMethod) {        
        this.stealingMethod = stealingMethod;
    }
}
