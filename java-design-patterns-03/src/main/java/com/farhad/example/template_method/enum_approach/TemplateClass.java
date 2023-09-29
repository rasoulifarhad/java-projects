package com.farhad.example.template_method.enum_approach;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public class TemplateClass {
    
    @Setter
    private Hooks hooks;

    public final void templateMethod() {
        setup();
        hooks.primitiveOperation1();
        hooks.primitiveOperation2();
        teardown();        
    }

    private void setup() {
        System.out.println("Setup " + hooks.description());
    }

    private void teardown() {
        System.out.println("teardown " + hooks.description());
    }

}
