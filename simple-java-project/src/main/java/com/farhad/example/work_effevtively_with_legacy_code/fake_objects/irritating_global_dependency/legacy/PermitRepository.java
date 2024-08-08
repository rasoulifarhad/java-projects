package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.irritating_global_dependency.legacy;

public class PermitRepository {

    private static final PermitRepository INSTANCE = new PermitRepository();
    
    public static PermitRepository getInstance() {
        return INSTANCE;
    }

    public Permit findAssociatedPermit(PermitNotice notice) {
        return null;
    }

}
