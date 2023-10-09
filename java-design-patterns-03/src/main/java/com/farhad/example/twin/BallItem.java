package com.farhad.example.twin;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BallItem  extends GameItem {

	private int posX;
	private int posY;

	@Setter
	private int dx;
	@Setter
	private int dy;

	private boolean isSuspended;
	@Setter
	private BallThread twin;

	
	public BallItem() {
		this(0, 0);
	}

	public BallItem(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}

	@Override
	public void doDraw() {
		log.info("doDraw Pos:({}, {})", posX, posY);
	}

	public void move() {
		log.info("move");
		posX += dx;
		posY += dy;
	}

	@Override
	public void click() {
		isSuspended = !isSuspended;
		if(isSuspended) {
			twin.suspendMe();
		} else {
			twin.resumeMe();
		}
	}

}
