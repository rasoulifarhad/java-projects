package com.farhad.example.design_principles02.grasp.coupling.good;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class VideoStore {

	List<Video> videos = new ArrayList<>();

	public List<Video> getAllVideos() {
		return new ArrayList<>(videos);
	}

	public Video getVideo(String title) {
		List<Video> videos = getAllVideos();
		return videos.stream()
				.filter(v -> v.getTitle().equals(title))
				.findFirst()
				.orElse(null);
	}
}
