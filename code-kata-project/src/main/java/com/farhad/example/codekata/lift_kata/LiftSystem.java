package com.farhad.example.codekata.lift_kata;

import java.util.Collections;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LiftSystem {

    private final List<Integer> floors;
    private final List<Call> calls;
    private final List<Lift> lifts;

    public List<Integer> getFloorsInDescendingOrder() {
        return Collections.emptyList();
    }

    public List<Call> getCallsForFloor(int floor) {
        return Collections.emptyList();
    }

    public List<Lift> getLifts() {
        return Collections.emptyList();
    }

    public void tick() {
        // TODO: implement this method
    }

}
