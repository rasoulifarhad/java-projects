package com.farhad.example.codekata.lift_kata;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LiftSystem {

    private final List<Integer> floors;
    private final List<Call> calls;
    private final List<Lift> lifts;

    public List<Integer> getFloorsInDescendingOrder() {
        List<Integer> shallowCopy = new ArrayList<>(floors);
        Collections.reverse(shallowCopy);
        return shallowCopy;
    }

    public List<Call> getCallsForFloor(int floor) {
        return calls.stream()
            .filter(call -> call.getFloor() == floor)
            .collect(toList());
    }

    public List<Lift> getLifts() {
        return lifts;
    }

    public void tick() {
        // TODO: implement this method
    }

}
