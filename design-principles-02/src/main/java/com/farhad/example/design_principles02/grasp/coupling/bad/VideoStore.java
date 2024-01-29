package com.farhad.example.design_principles02.grasp.coupling.bad;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class VideoStore {

	List<Video> videos = new ArrayList<>();

	public List<Video> getAllVideos() {
		return new ArrayList<>(videos);
	}
}
