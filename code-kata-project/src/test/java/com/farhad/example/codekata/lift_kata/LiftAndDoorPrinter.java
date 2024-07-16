package com.farhad.example.codekata.lift_kata;

public class LiftAndDoorPrinter implements LiftPrinter {

    @Override
    public String printLiftForFloor(Lift lift, int floor) {
        if(lift.getFloor() == floor) {
            return printLift(lift, floor);
        } else {
            String padding = LiftSystemPrinter.getWhitespace(lift.getId().length());
            if(lift.hasRequestForFloor(floor)) {
                return "  *" + padding;
            } else {
                return "   " + padding;
            }
        }

    }

    private String printLift(Lift lift, int floor) {
        if(lift.areDoorOpen()) {
            if(lift.hasRequestForFloor(floor)) {
                return "]*" + lift.getId() + "[";
            } else {
                return " ]" + lift.getId() + "[";
            }
        } else {
            if(lift.hasRequestForFloor(floor)) {
                return "[*" + lift.getId() + "]";
            } else {
                return " [" + lift.getId() + "]";
            }
        }
    }

}
