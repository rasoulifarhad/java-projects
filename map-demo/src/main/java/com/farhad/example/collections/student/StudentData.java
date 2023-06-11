package com.farhad.example.collections.student;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentData {

    private String name = "";
    private List<String> hobbies = new ArrayList<>(); 
    private String level = "";
    private String gpa = "";
    private List<String> majors = new ArrayList<>();

    public StudentData(String name, List<Hobby> hobbies, GradeLevel level, GradePointAverage gpa, List<Major> majors) {
        this.name = name;
        this.hobbies =  Hobby.names(hobbies);
        this.level = level.getName();
        this.gpa = gpa.getName();
        this.majors = Major.names(majors);
    } 

    
}
