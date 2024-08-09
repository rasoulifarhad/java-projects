package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.irritating_global_dependency.better2;

import java.util.HashMap;
import java.util.Map;

public class TestingPermitRepository implements IPermitRepository {
    private Map<PermitNotice, Permit> permits = new HashMap<>();

    public void addAssociatedPermit(PermitNotice notice, Permit Permit) {
        permits.put(notice, Permit);
    }

    @Override
    public Permit findAssociatedPermit(PermitNotice notice) {
        return permits.get(notice);
    }

}
