package com.farhad.example.ddd_tips.education_domain.domain.command;

import com.farhad.example.ddd_tips.education_domain.domain.model.CourseInfo;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class CreateCourse implements Command {
    
    private CourseInfo courseInfo;
}
