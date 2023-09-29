package com.farhad.example.template_method.enum_approach;

public class Context {
    
    public static void main(String[] args) {
        TemplateClass templateClass = new TemplateClass(Hooks.HOOKSA);
        templateClass.templateMethod();

        System.out.println();

        templateClass.setHooks(Hooks.HOOKSB);
        templateClass.templateMethod();
    }
}
