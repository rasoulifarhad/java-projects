package com.farhad.example.codekata.bowling;

public class Game {

    public int score() {
        return itsScore;
    }

    public void add(int pins) {
        itsThrows[itsCurrentThrow++] = pins;
        itsScore += pins;
        adjustCurrentFrame();
    }

    private void adjustCurrentFrame() {
        if (firstThrow == true) {
            firstThrow = false;
            itsCurrentFrame++;
        } else {
            firstThrow = true;
        }
    }

    public int scoreForFrame(int theFrame) {

        int ball = 0;
        int score = 0;
        for (int currentFrame = 0; currentFrame < theFrame; currentFrame++) {
            int firstThrow = itsThrows[ball++];
            int secondThrow = itsThrows[ball++];
            int frameScore = firstThrow + secondThrow;
            // spare needs next frames first throw
            if (frameScore == 10)
                score += frameScore + itsThrows[ball];
            else
                score += frameScore;
        }
        return score;
    }

    private int itsScore = 0;
    private int[] itsThrows = new int[21];
    private int itsCurrentThrow = 0;
    private int itsCurrentFrame = 0;
    private boolean firstThrow = true;

    public Integer getCurrentFrame() {
        return itsCurrentFrame;
    }

}
