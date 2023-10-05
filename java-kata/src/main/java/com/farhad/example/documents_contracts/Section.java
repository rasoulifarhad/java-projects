package com.farhad.example.documents_contracts;

import java.util.stream.Stream;

import com.farhad.example.documents_contracts.constraints.Constraint;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data 
public class Section {
    
    private String name;
    private String specification;

    public boolean isSpecValid(Constraint constraint) {
        return constraint.isValid(this);
    }

    public Stream<ContractViolation> validateSpec(Constraint constraint) {
        return constraint.check(this);
    }
}
