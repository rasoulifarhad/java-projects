package com.farhad.example.refactoring.extract_class.demo2;

public class Person {

    private String name;
    private String officeAreaCode;
    private String officeNumber;
    private TelephoneNumber telephoneNumber;
    

    public Person() {
        telephoneNumber = new TelephoneNumber();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOfficeAreaCode() {
        return officeAreaCode;
    }
    public void setOfficeAreaCode(String officeAreaCode) {
        this.officeAreaCode = officeAreaCode;
    }
    public String getOfficeNumber() {
        return officeNumber;
    }
    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    public String getTelephoneNumber() {
        return String.format("%s %s",officeAreaCode, officeNumber);
    }
}
