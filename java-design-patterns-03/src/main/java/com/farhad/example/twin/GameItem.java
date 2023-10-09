package com.farhad.example.twin;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class GameItem {

	static final List<GameItem> items =  new ArrayList<>();

	public void draw() {
		log.info("draw");
		doDraw();
	}

	public abstract void doDraw();

	public abstract void click();
}
