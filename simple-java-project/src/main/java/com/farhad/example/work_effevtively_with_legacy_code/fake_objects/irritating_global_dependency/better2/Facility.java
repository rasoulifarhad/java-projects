package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.irritating_global_dependency.better2;
// a class in a Java application that records building permits for a
// governmental agency.
public class Facility {

    public static final int RESIDENCE = 0;
    
    private Permit basePermit;

    public Facility(int facilityCode, String owner, PermitNotice notice) throws PermitViolation {

        Permit associatedPermit = PermitRepository.getInstance().findAssociatedPermit(notice);

        if(associatedPermit.isValid() && !notice.isValid()) {
            basePermit = associatedPermit;
        } else if(!notice.isValid()) {
            Permit permit = new Permit(notice);
            permit.validate();
            basePermit = permit;
        } else {
            throw new PermitViolation(associatedPermit);
        }
    }

    //
    //
}
