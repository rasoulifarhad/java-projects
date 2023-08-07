package com.farhad.example.designpatterns.dependencyinversionprinciple;

import org.junit.jupiter.api.Test;

import com.farhad.example.designpatterns.dependencyinversionprinciple.ElectricPowerSwitchDIDemo.Switch;
import com.farhad.example.designpatterns.dependencyinversionprinciple.ElectricPowerSwitchDIDemo.Switchable;

public class ElectricPowerSwitchDIDemo_ElectricPowerSwitchTest {
    @Test
    void testPress() {
        Switchable switchableBulb = new ElectricPowerSwitchDIDemo.LightBulb();
        Switch bulbPowetrSwitch = new ElectricPowerSwitchDIDemo.ElectricPowerSwitch(switchableBulb);
        bulbPowetrSwitch.press();
        bulbPowetrSwitch.press();

        Switchable switchableFan = new ElectricPowerSwitchDIDemo.Fan();
        Switch fanSwitch = new ElectricPowerSwitchDIDemo.ElectricPowerSwitch(switchableFan);
        fanSwitch.press();
        fanSwitch.press();
    }
}
