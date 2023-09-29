package com.farhad.example.bridge.standard_approach.demo2;

public class SaveStudentInDB {
  
    public void saveInDb(Student student) {
        checkAccess();

        validateObject();

        setAuditFields();


        storeDataInDb();


    }


    private void storeDataInDb() {
    }

    private void setAuditFields() {
    }

    private void validateObject() {
    }

    private void checkAccess() {
    }
    
}
