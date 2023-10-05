package com.farhad.example.documents_contracts.constraints;

import java.util.stream.Stream;

import com.farhad.example.documents_contracts.ContractViolation;
import com.farhad.example.documents_contracts.Section;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SizeLimit implements Constraint {

    private final int max;

    @Override
    public boolean isValid(Section section) {
        return section.getSpecification().split(" ").length < max;
    }

    @Override
    public Stream<ContractViolation> check(Section section) {
        return isValid(section) 
                ? Stream.empty() 
                : Stream.of(new ContractViolation(
                    "SECTION_CONSTRAINT_VIOLATION",
                    String.format(
                        "Specification %s not valid according to section constraint %s",
                        section, 
                        this)));
    }
    
}
