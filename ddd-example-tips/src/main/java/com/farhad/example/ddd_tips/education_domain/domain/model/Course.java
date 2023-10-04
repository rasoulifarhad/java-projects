package com.farhad.example.ddd_tips.education_domain.domain.model;

import java.util.Set;

public class Course {

    private CourseId courseId;
    private String courseName;
    private int capacity;
    Set<Subscription> subscriptions;
}
