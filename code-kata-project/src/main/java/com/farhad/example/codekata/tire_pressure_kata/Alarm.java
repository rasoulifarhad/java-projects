package com.farhad.example.codekata.tire_pressure_kata;

import lombok.Getter;

public class Alarm {

    private static final double LOW_PRESSURE_THRESHOLD = 17;
    private static final double HIGH_PRESSURE_THRESHOLD = 17;

    protected Sensor sensor = new Sensor();

    @Getter
    private boolean alarmOn = false;

    public void check() {

        double psiPressureValue = sensor.popNextPressurePsiValue();
        if (psiPressureValue < LOW_PRESSURE_THRESHOLD || HIGH_PRESSURE_THRESHOLD < psiPressureValue) {
            alarmOn = true;
        }

    }
}
