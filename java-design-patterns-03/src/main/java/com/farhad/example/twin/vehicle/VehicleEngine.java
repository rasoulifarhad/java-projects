package com.farhad.example.twin.vehicle;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class VehicleEngine extends AbstractVehiclePart{

	private VehicleBreaks twin;

    void setBreaks(VehicleBreaks breaks) {
        this.twin = breaks;
    }	
	
	@Override
	void init() {
		if(twin.isReady()) {
			setReady(true);
		} else {
			setReady(true);
			twin.init();
		}
		System.out.println("VehicleEngine, initiated");
	}
	
}
