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

    public Section createSection(String semester, String place, String daysAndTimes) {
        return new Section(this, semester, place, daysAndTimes);
    }

    public static void main(String[] args) {
        
        Course cs350 = new Course("CS 350", "Data Structures");
        Section cs350Section1 = cs350.createSection("Fall 2023", "Lecture Hall 25 ", "T H 1-2:15");
        Section cs350Section2 = cs350.createSection("Fall 2023", "Lecture Hall 25 ", "M W F 10-10:50");
    }

    
}
