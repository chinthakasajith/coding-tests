package org.dius.bowling.sb;

import java.util.List;

public class BowlingGameImpl implements BowlingGame {

    private final List<Frame> frames;
    private static final int MAX_FRAMES = 10;
    private static final int MAX_PINS = 10;
    private static final int MAX_ATTEMPTS_PER_FRAME = 2;
    private int frameCounter = 0;
    private int strikeCounter = 0;
    private static final int ALL_STRIKE_SCORE = 300;



    public BowlingGameImpl(List<Frame> frames) {
        this.frames = frames;
    }

    @Override
    public void roll(int noOfPins) {

    }


    @Override
    public int score() {
        return 0;
    }

    private class Frame {

        private int[] scores = new int[MAX_ATTEMPTS_PER_FRAME];
        private int noOfPins = 10;
        private int noAttempts = 0;
        private boolean isStrike = false;

        private boolean isSpare() {
            return noOfPins == 0 && noAttempts == MAX_ATTEMPTS_PER_FRAME && !isStrike;
        }

        private boolean isStrike() {
            return noOfPins == 0 && noAttempts == 1 && isStrike;
        }

        private boolean isDone () {
            return noAttempts == MAX_ATTEMPTS_PER_FRAME || score() == MAX_PINS;
        }

        private void setScore(int score) {

            scores[noAttempts++] = score;
            noOfPins -= score; // keep track of remaining pins/frame

            if (score == MAX_PINS && noAttempts == 1) {
                isStrike = true;
                strikeCounter++;
            }
        }

        private void limitToOneAttempt(){
            scores[1] = 0;
            noAttempts++;
        }

        private int score() {
            return scores[0] + scores[1];
        }

        private int getFirstScore() {
            return scores[0];
        }

        private int getSecondScore() {
            return scores[1];
        }

    }

}
