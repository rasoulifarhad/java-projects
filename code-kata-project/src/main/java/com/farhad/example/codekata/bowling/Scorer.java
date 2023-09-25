package com.farhad.example.codekata.bowling;

public class Scorer {

    private int[] itsThrows = new int[21];
    private int itsCurrentThrow = 0;
    private int ball;

    public void addThrow(int pins) {
        itsThrows[itsCurrentThrow++] = pins;
    }

    public int scoreForFrame(int theFrame) {

        ball = 0;

        int score = 0;
        for (int currentFrame = 0; currentFrame < theFrame; currentFrame++) {

            if (strike()) {
                score += 10 + nextTwoBallsForStrike();
                ball++;
            } else if (spare()) {
                score += 10 + nextBallForSpare();
                ball += 2;
            } else {
                score += twoBallsInFrame();
                ball += 2;
            }
        }
        return score;
    }


    boolean strike() {
        return itsThrows[ball] == 10;
    }

    int nextTwoBallsForStrike() {
        return itsThrows[ball + 1] + itsThrows[ball + 2];
    }

    boolean spare() {
        return (itsThrows[ball] + itsThrows[ball + 1]) == 10;
    }

    int nextBallForSpare() {
        return itsThrows[ball + 2];
    }

    int twoBallsInFrame() {
        return itsThrows[ball] + itsThrows[ball + 1];
    }

}
