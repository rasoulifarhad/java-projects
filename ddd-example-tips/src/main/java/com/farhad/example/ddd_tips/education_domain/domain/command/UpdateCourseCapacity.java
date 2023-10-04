package com.farhad.example.ddd_tips.education_domain.domain.command;

import com.farhad.example.ddd_tips.education_domain.domain.model.CourseSubscription;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class UpdateCourseCapacity implements Command {
    
    private CourseSubscription courseSubscription;

}
