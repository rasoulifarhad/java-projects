package com.farhad.example.design_principles02.grasp.creator;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class VideoStore {

	List<Video> videos = new ArrayList<>();

	public Video createVideo(String title) {
		return new Video(title);
	}
}
