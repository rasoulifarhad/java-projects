package com.farhad.example.ddd_tips.education_domain.domain.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class StudentId {
    
    private String uuid;
}
