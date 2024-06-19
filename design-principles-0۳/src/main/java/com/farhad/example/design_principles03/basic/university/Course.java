package com.farhad.example.design_principles03.basic.university;

import lombok.Getter;
import lombok.Setter;

public class Course {

    @Getter
    private String id;
    @Getter
    private String name;
    @Getter
    @Setter
    private int numberOfCredit;
    @Getter
    @Setter
    private String description;

    public Course(String courseId, String courseName) {
        this.id = courseId;
        this.name = courseName;
    }

    
}
