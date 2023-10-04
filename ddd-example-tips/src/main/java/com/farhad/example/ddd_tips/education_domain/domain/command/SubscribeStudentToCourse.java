package com.farhad.example.ddd_tips.education_domain.domain.command;

import com.farhad.example.ddd_tips.education_domain.domain.model.CourseSubscription;
import com.farhad.example.ddd_tips.education_domain.domain.model.Student;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class SubscribeStudentToCourse implements Command{
    
    private CourseSubscription courseSubscription;
    private Student student;

}
