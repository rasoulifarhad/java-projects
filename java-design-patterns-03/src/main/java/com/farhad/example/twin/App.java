package com.farhad.example.twin;

public class App {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		BallItem ballItem = newBall(1,3);
		ballItem.click();
		ballItem.click();

		Thread.sleep(2000);
		ballItem.click();
	}

	private static BallItem newBall(int posX, int posY) {
		BallItem ballItem = new BallItem(posX, posY);
		ballItem.setDx(1);
		ballItem.setDy(1);
		BallThread ballThread = new BallThread();
		ballItem.setTwin(ballThread);
		ballThread.setTwin(ballItem);
		ballThread.start();
		return ballItem;

	}
}
