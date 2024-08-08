package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.irritating_global_dependency.better;

import org.junit.jupiter.api.Test;

public class FacilityTest {

    @Test
    public void testCreate() throws PermitViolation {
        PermitNotice notice = new PermitNotice(0, "a");
        Facility facility = new Facility(Facility.RESIDENCE, "b", notice);
    }

}
