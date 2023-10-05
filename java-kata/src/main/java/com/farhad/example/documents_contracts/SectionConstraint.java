package com.farhad.example.documents_contracts;

import com.farhad.example.documents_contracts.constraints.Constraint;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class SectionConstraint {

    private String sectionName;
    private Constraint constraint;

    public boolean matches(Section section) {
        return section.getName().equals(sectionName);
    }
}
