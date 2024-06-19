package com.farhad.example.design_principles03.basic.university;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Section {

    private Course course;
    private String semester;
    @Setter
    private String place;
    @Setter
    private String daysAndTimes;

    public Section(Course theCourse, String theSemester, String thePlace, String theDaysAndTimes) {
        this.course = theCourse;
        this.semester = theSemester;
        this.place = thePlace;
        this.daysAndTimes = theDaysAndTimes;
    };

    
}
