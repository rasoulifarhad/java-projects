package com.farhad.example.functional_interface.vehicle_demo.oo.vocalCommand;

import com.farhad.example.functional_interface.vehicle_demo.oo.Vehicle;
import com.farhad.example.functional_interface.vehicle_demo.oo.VocalCommand;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public abstract class AbstractVehicleCommand implements VocalCommand {
    
    private final Vehicle vehicle;

    public abstract void execute();

    

}
