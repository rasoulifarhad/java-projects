package com.farhad.example.codekata.bowling;

public class Game {

    private int itsScore = 0;

    private int itsCurrentFrame = 1;
    private boolean firstThrowInFrame = true;
    public Scorer scorer = new Scorer();

    public Integer getCurrentFrame() {
        return itsCurrentFrame;
    }

    public int score() {
        return scoreForFrame(getCurrentFrame() - 1);
    }

    public int scoreForFrame(int theFrame) {
        return scorer.scoreForFrame(theFrame);
    }

    public void add(int pins) {
        scorer.addThrow(pins);
        itsScore += pins;
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if (firstThrowInFrame == true) {
            if (pins == 10) {// strike
                itsCurrentFrame++;
            } else {
                firstThrowInFrame = false;
            }
        } else {
            firstThrowInFrame = true;
            itsCurrentFrame++;
        }
        itsCurrentFrame = Math.min(11, itsCurrentFrame);
    }

}
