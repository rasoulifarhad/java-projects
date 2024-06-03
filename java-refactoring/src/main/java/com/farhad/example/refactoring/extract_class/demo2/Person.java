package com.farhad.example.refactoring.extract_class.demo2;

public class Person {

    private String name;
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
        return telephoneNumber.getAreaCode();
    }
    public void setOfficeAreaCode(String officeAreaCode) {
        this.telephoneNumber.setAreaCode(officeAreaCode);;
    }
    public String getOfficeNumber() {
        return telephoneNumber.getNumber();
    }
    public void setOfficeNumber(String officeNumber) {
        this.telephoneNumber.setNumber(officeNumber);
    }

    public String getTelephoneNumber() {
        return telephoneNumber.toString();
    }
}
