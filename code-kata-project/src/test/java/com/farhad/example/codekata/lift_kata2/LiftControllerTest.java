package com.farhad.example.codekata.lift_kata2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LiftControllerTest {

    private ILiftController lift = new LiftController();

    @Test
    public void displaysFirstFloorIfStartAt1InitialFloor() {
        Assertions.assertThat( new LiftController(1).getCurrentFloor()).isEqualTo(1);
    }
}
