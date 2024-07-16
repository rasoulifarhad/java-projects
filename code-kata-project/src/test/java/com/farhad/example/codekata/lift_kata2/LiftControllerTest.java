package com.farhad.example.codekata.lift_kata2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LiftControllerTest {

    private ILiftController lift = new LiftController();

    @Test
    public void displaysGroundFloorIfStartAt0() {
        Assertions.assertThat( new LiftController(0).getCurrentFloor()).isEqualTo(0);
    }

    @Test
    public void displaysFirstFloorIfStartAt1() {
        Assertions.assertThat( new LiftController(1).getCurrentFloor()).isEqualTo(1);
    }

}
