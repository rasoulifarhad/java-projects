package com.farhad.example.twin.vehicle;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class VehicleBreaks extends AbstractVehiclePart {

	private VehicleEngine twin;

	void setEngine(VehicleEngine engine) {
		this.twin = engine;
	}

	@Override
	void init() {
		if(twin.isReady()) {
			setReady(true);
		} else {
			setReady(true);
			twin.init();
		}
		System.out.println("VehicleBreaks, initiated");	}
	
}
