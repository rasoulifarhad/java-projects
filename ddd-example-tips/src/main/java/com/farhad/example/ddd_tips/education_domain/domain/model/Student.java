package com.farhad.example.ddd_tips.education_domain.domain.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Student implements AggregateRoot{

    @EqualsAndHashCode.Include
    private StudentId studentId;

    @Override
    public StudentId id() {
        return studentId;
    }
    
}
