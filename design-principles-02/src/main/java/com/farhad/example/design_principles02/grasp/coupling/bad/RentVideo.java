package com.farhad.example.design_principles02.grasp.coupling.bad;

import java.util.List;

import lombok.Data;

@Data
public class RentVideo {

	private VideoStore videoStore;
	public Video getVideo(String title) {
		List<Video> videos = videoStore.getAllVideos();
		return videos.stream()
			.filter(v -> v.getTitle().equals(title))
				.findFirst()
				.orElse(null);
	}
}
