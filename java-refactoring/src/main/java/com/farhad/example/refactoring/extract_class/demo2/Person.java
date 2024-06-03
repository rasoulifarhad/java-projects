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
        return telephoneNumber.getOfficeAreaCode();
    }
    public void setOfficeAreaCode(String officeAreaCode) {
        this.telephoneNumber.setOfficeAreaCode(officeAreaCode);;
    }
    public String getOfficeNumber() {
        return telephoneNumber.getOfficeNumber();
    }
    public void setOfficeNumber(String officeNumber) {
        this.telephoneNumber.setOfficeNumber(officeNumber);
    }

    public String getTelephoneNumber() {
        return String.format("%s %s",officeAreaCode, officeNumber);
    }
}
