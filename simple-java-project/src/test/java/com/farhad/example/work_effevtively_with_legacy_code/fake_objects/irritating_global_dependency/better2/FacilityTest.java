package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.irritating_global_dependency.better2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FacilityTest {

        @BeforeEach
    public void setup() {
        IPermitRepository repository = PermitRepository.getInstance();
        //
        // add permits to repository here
        //

        PermitRepository.setTestingInstance(repository);
    }

    @Test
    public void testCreate() throws PermitViolation {
        PermitNotice notice = new PermitNotice(0, "a");
        Facility facility = new Facility(Facility.RESIDENCE, "b", notice);
    }

}
