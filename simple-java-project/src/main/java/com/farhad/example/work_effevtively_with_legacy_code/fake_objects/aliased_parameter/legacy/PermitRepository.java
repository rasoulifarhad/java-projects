package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.aliased_parameter.legacy;

public class PermitRepository {

    private static final PermitRepository INSTANCE = new PermitRepository();
    
    public static PermitRepository getInstance() {
        return INSTANCE;
    }

    public Permit findAssociatedPermit(PermitNotice notice) {
        return null;
    }

    public Permit findAssociatedFromOrigination(OriginationPermit permit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAssociatedFromOrigination'");
    }

}
