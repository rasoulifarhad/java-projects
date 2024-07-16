package com.farhad.example.codekata.lift_kata2;

import java.util.List;
import java.util.Optional;

public interface ILiftController {

    int getCurrentFloor();
    public Optional<Direction> getCurrentDirection();
    public List<Call> getNextCalls();
    public LiftEngineCommand onFloor();
    public Optional<LiftEngineCommand> onDoosClosed();
    public Optional<LiftEngineCommand> call(Call call);
}