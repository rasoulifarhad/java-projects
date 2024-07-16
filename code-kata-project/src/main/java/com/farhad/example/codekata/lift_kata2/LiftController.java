package com.farhad.example.codekata.lift_kata2;

import static java.util.Optional.empty;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class LiftController implements ILiftController {


    public LiftController(int initialFloor) {
    }

    public LiftController() {
        this(0);
    }

    @Override
    public int getCurrentFloor() {
        return 1;
    }

    @Override
    public Optional<Direction> getCurrentDirection() {
        return empty();
    }

    @Override
    public List<Call> getNextCalls() {
        return Collections.emptyList();
    }

    @Override
    public LiftEngineCommand onFloor() {
        return LiftEngineCommand.OPEN_DOORS;
    }

    @Override
    public Optional<LiftEngineCommand> onDoosClosed() {
        return empty();
    }

    @Override
    public Optional<LiftEngineCommand> call(Call call) {
        return empty();
    }
}
