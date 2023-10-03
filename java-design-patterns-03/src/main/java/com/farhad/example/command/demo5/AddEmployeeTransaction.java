package com.farhad.example.command.demo5;

public class AddEmployeeTransaction implements Transaction {

    private String name;
    private String address;

    private PayClassification payClassification;

    @Override
    public void validate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validate'");
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

}
