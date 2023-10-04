package com.farhad.example.ddd_tips.education_domain.domain.command;

import com.farhad.example.ddd_tips.education_domain.domain.model.Student;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class CreateStudent  implements Command {
    
    private Student student;
}
