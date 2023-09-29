package com.farhad.example.bridge.standard_approach.demo2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveStudentInFile implements FileSaver {

    private String filePath;

    private Student student;

    
    public SaveStudentInFile(String filePath, Student student) {
        this.filePath = filePath;
        this.student = student;
    }

    public void save(Student student) {
        checkAccess();

        validateObject();

        setAuditFields();

        writeDataInFile();

    }

    private void setAuditFields() {
    }

    private void validateObject() {
    }

    private void checkAccess() {
    }

    @Override
    public void writeDataInFile() {
        try {

            FileOutputStream fileOut = new FileOutputStream(filePath);

            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(student);

            objectOut.close();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }


}
