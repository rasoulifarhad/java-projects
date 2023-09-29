package com.farhad.example.template_method.enum_approach;

public enum Hooks {
    
    HOOKSA{

        @Override
        public String description() {
            return "HOOKSA";
        }

        @Override
        public void primitiveOperation1() {
            System.out.println("HOOKSA primitiveOperation1");
        }

        @Override
        public void primitiveOperation2() {
            System.out.println("HOOKSA primitiveOperation1");
        }
        
    },
    HOOKSB {

        @Override
        public String description() {
            return "HOOKSB";
        }

        @Override
        public void primitiveOperation1() {
            System.out.println("HOOKSB primitiveOperation1");
        }

        @Override
        public void primitiveOperation2() {
            System.out.println("HOOKSB primitiveOperation2");
        }

    };

    public abstract String description();

    public abstract void primitiveOperation1();
    public abstract void primitiveOperation2() ;
}
