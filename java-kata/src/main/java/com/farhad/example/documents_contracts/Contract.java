package com.farhad.example.documents_contracts;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Contract {
    
    private Set<SectionConstraint> sectionConstraints = new HashSet<>();
}
