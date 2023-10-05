package com.farhad.example.documents_contracts.constraints;

import java.util.stream.Stream;

import com.farhad.example.documents_contracts.ContractViolation;
import com.farhad.example.documents_contracts.Section;

public interface Constraint {
    
    boolean isValid(Section section);
   Stream<ContractViolation> check(Section section);    
}
