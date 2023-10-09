package com.farhad.example.twin;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BallThread extends Thread {

	@Setter
	private BallItem twin;

	private volatile boolean isSuspended = false;
	private volatile boolean isRunning = true;
	
	@Override
	// public void run() {
	// 	while(isRunning) {
	// 		if(!isSuspended) {
	// 			twin.draw();
	// 			twin.move();

	// 		}
	// 		try {
	// 			Thread.sleep(250);
	// 		} catch (InterruptedException e) {
	// 			throw new RuntimeException(e);
	// 		}
	// 	}
	// }

	public void run() {
		while(isRunning) {
			if(!isSuspended) {
				twin.draw();
				twin.move();
				twin.draw();

			}
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}


	public void suspendMe() {
		isSuspended = true;
		log.info("Begin to suspend BallThread");
	}

	public void resumeMe() {
		isSuspended = false;
		log.info("Begin to resume BallThread");
	}

	public void stopMe() {
		isRunning = false;
		isSuspended = true;
	}

	
	
}
