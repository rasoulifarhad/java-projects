package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.aliased_parameter.legacy;

public class OriginationPermit extends FacilityPermit {

    public OriginationPermit(PermitNotice notice) {
        super(notice);
    }

    public void validate() {
        // form connection to database
        // ...
        
        // query for validation information 
        // ...

        // set the validation flag
        // ...

        // close database
        // ...
    } 

}
