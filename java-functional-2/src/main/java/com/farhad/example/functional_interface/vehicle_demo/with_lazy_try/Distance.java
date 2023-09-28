package com.farhad.example.functional_interface.vehicle_demo.with_lazy_try;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class Distance {

    public static final Distance ONE_METER = Distance.meter(1) ;
    public static final Distance THREE_METER = Distance.meter(3) ;
    public static final Distance FIVE_METER = Distance.meter(5) ;
    public static final Distance SEVEN_INCH  = Distance.inch(7) ;
    public static final Distance TEN_METER = Distance.meter(10) ;

    private enum Unit {
        METER, INCH
    }

    private final int value;
    private final Unit unit;

    public static Distance meter(final int value) {
        return new Distance(value,Unit.METER);
    }

    public static Distance inch(final int value) {
        return new Distance(value,Unit.METER);
    }

}
