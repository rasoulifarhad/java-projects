package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.aliased_parameter.legacy;

public class IndustrialFacility extends Facility {

    Permit basPermit;

    

    public IndustrialFacility(int facilityCode, String owner, OriginationPermit permit) throws PermitViolation {

        Permit associatedPermit = 
            PermitRepository.getInstance()
                .findAssociatedFromOrigination(permit);
        if(associatedPermit.isValid() && !permit.isValid()) {
            basPermit = associatedPermit; 
        } else if(!permit.isValid()) {
            permit.validate();
            basPermit = permit;
        } else {
            throw new PermitViolation(permit);
        }
    }
}
