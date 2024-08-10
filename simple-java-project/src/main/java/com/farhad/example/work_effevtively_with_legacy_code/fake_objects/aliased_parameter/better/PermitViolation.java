package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.aliased_parameter.better;

public class PermitViolation extends Exception {

    private Permit associatedPermit;

    public PermitViolation(Permit associatedPermit) {
        this.associatedPermit = associatedPermit;
    }

}
