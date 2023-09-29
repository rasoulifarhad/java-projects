package com.farhad.example.bridge.standard_approach.demo2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCourseInFile implements FileSaver {

    private String filePath;

    private Course course;

    
    public SaveCourseInFile(String filePath, Course course) {
        this.filePath = filePath;
        this.course = course;
    }

    public void save(Course course) {
        
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

            objectOut.writeObject(course);

            objectOut.close();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

}
