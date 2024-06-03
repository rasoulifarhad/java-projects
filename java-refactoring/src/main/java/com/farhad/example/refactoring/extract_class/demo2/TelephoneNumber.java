package com.farhad.example.refactoring.extract_class.demo2;

public class TelephoneNumber {

    private String areaCode;
    private String number;

    public String getAreaCode() {
        return areaCode;
    }
    public void setAreaCode(String officeAreaCode) {
        this.areaCode = officeAreaCode;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String officeNumber) {
        this.number = officeNumber;
    }

    
    public String toString() {
        return String.format("%s %s",areaCode, number);
    }

}
