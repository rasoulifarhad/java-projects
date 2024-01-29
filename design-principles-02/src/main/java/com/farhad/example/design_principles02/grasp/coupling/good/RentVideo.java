package com.farhad.example.design_principles02.grasp.coupling.good;

import lombok.Data;

@Data
public class RentVideo {

	private VideoStore videoStore;

	public Video getVideo(String title) {
		return videoStore.getVideo(title);
	}
}
