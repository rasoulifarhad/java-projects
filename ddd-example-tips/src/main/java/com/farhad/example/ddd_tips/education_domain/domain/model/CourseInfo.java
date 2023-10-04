package com.farhad.example.ddd_tips.education_domain.domain.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class CourseInfo implements AggregateRoot {
    
    @EqualsAndHashCode.Include
    private CourseInfoId courseInfoId;

    @Override
    public Object id() {
        return courseInfoId;
    }

    
}
