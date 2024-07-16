package com.farhad.example.codekata.lift_kata2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LiftControllerTest {

    private ILiftController lift = new LiftController();

    @Test
    public void displaysInitialFloor() {
        Assertions.assertThat(lift.getCurrentFloor()).isEqualTo(0);
    }
}
